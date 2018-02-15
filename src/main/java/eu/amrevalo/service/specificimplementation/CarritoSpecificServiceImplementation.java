/*
 * Copyright (c) 2017-2018 
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & DAW students
 * 
 * GESANE: Free Open Source Health Management System
 *
 * Sources at:
 *                            https://github.com/rafaelaznar/gesane-server
 *                            https://github.com/rafaelaznar/gesane-client
 *                            https://github.com/rafaelaznar/gesane-database
 *
 * GESANE is distributed under the MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package eu.amrevalo.service.specificimplementation;

import com.google.gson.Gson;
import eu.amrevalo.bean.helper.MetaBeanHelper;
import eu.amrevalo.bean.helper.ReplyBeanHelper;
import eu.amrevalo.bean.specificimplementation.CarritoSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.ClienteSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.PedidoSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.ProductoSpecificBeanImplementation;

import eu.amrevalo.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.amrevalo.connection.publicinterface.ConnectionInterface;
import eu.amrevalo.dao.specificimplementation.PedidoSpecificDaoImplementation;
import eu.amrevalo.dao.specificimplementation.ProductoSpecificDaoImplementation;
import eu.amrevalo.factory.ConnectionFactory;
import eu.amrevalo.helper.GsonHelper;
import eu.amrevalo.helper.Log4jHelper;
import eu.amrevalo.helper.constant.ConfigurationConstants;
import eu.amrevalo.helper.constant.ConnectionConstants;

import eu.amrevalo.service.genericimplementation.TableGenericServiceImplementation;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;

public class CarritoSpecificServiceImplementation extends TableGenericServiceImplementation {

    public CarritoSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }

    private CarritoSpecificBeanImplementation find(Integer id, ArrayList<CarritoSpecificBeanImplementation> alCarrito) {
        if (alCarrito != null) {
            Iterator<CarritoSpecificBeanImplementation> iterator = alCarrito.iterator();
            while (iterator.hasNext()) {
                CarritoSpecificBeanImplementation oCarritoBean = iterator.next();
                ProductoSpecificBeanImplementation oProducto = (ProductoSpecificBeanImplementation) oCarritoBean.getObj_producto().getBean();
                if (oProducto.getId() == id) {
                    return oCarritoBean;
                }
            }
        }
        return null;
    }

    public ReplyBeanHelper add() throws Exception {
        if (this.checkPermission("add")) {
            ArrayList<CarritoSpecificBeanImplementation> alCarrito = (ArrayList) oRequest.getSession().getAttribute("carrito");
            ReplyBeanHelper oReplyBean = null;
            CarritoSpecificBeanImplementation oCarritoBeanEnCarrito = null;
            int id = Integer.parseInt(oRequest.getParameter("id"));
            int cantidad = Integer.parseInt(oRequest.getParameter("cantidad"));
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            if (alCarrito == null) {
                alCarrito = new ArrayList<CarritoSpecificBeanImplementation>();
            }
            oCarritoBeanEnCarrito = find(id, alCarrito);
            if (oCarritoBeanEnCarrito != null) {
                oCarritoBeanEnCarrito.setCantidad(oCarritoBeanEnCarrito.getCantidad() + cantidad);
            } else {
                try {
                    oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                    oConnection = oPooledConnection.newConnection();
                    CarritoSpecificBeanImplementation oCarritoBean = new CarritoSpecificBeanImplementation();
                    oCarritoBean.setCantidad(cantidad);
                    ProductoSpecificDaoImplementation oProductoDao = new ProductoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                    MetaBeanHelper oMetaBeanHelper = (MetaBeanHelper) oProductoDao.get(id, ConfigurationConstants.jsonMsgDepth);
                    ProductoSpecificBeanImplementation oProductoBeanAdd = (ProductoSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    oCarritoBean.setId_producto(oProductoBeanAdd.getId());
                    oCarritoBean.setObj_producto(oMetaBeanHelper);
                    alCarrito.add(oCarritoBean);
                } catch (Exception ex) {
                    String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
                    Log4jHelper.errorLog(msg, ex);
                    throw new Exception(msg, ex);
                } finally {
                    if (oConnection != null) {
                        oConnection.close();
                    }
                    if (oPooledConnection != null) {
                        oPooledConnection.disposeConnection();
                    }
                }
            }
            oRequest.getSession().setAttribute("carrito", alCarrito);
            oReplyBean = new ReplyBeanHelper(200, GsonHelper.getGson().toJson(alCarrito));
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, "Unauthorized operation");
        }
    }

    @Override
    public ReplyBeanHelper remove() throws Exception {
        if (this.checkPermission("remove")) {
            ArrayList<CarritoSpecificBeanImplementation> alCarrito = (ArrayList) oRequest.getSession().getAttribute("carrito");
            int id = Integer.parseInt(oRequest.getParameter("id"));
            ReplyBeanHelper oReplyBean = null;
            CarritoSpecificBeanImplementation oCarritoBeanEnCarrito = find(id, alCarrito);
            alCarrito.remove(oCarritoBeanEnCarrito);
            Gson oGson = GsonHelper.getGson();
            String strJson = oGson.toJson(alCarrito);
            oReplyBean = new ReplyBeanHelper(200, strJson);
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, "Unauthorized operation");
        }
    }

    public ReplyBeanHelper list() throws Exception {
        if (this.checkPermission("list")) {
            ArrayList<CarritoSpecificBeanImplementation> alCarrito = (ArrayList) oRequest.getSession().getAttribute("carrito");
            ReplyBeanHelper oReplyBean = null;
            Gson oGson = GsonHelper.getGson();
            String strJson = oGson.toJson(alCarrito);
            oReplyBean = new ReplyBeanHelper(200, strJson);
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, "Unauthorized operation");
        }
    }

    // falta implementar id_tienda
    public ReplyBeanHelper buy() throws Exception {
        if (this.checkPermission("buy")) {
            ArrayList<CarritoSpecificBeanImplementation> alCarrito = (ArrayList) oRequest.getSession().getAttribute("carrito");
            MetaBeanHelper oUsuarioBeanConMetaDatos = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
            // --> especifico cliente de proyecto tienda
            int idCliente = Integer.parseInt(oRequest.getParameter("cliente"));
            // --<
            ReplyBeanHelper oReplyBean = null;
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                if (alCarrito != null && alCarrito.size() > 0) {
                    oConnection.setAutoCommit(false);
                    PedidoSpecificBeanImplementation oPedidoBean = new PedidoSpecificBeanImplementation();
                    
                    ClienteSpecificBeanImplementation oClienteBean = new ClienteSpecificBeanImplementation();
                    // --> especifico cliente de proyecto tienda
                    oPedidoBean.setId_cliente(idCliente);
                    // --<
                    
                    //oPedidoBean.setFecha_pedido(Calendar.getInstance().getTime());
                    PedidoSpecificDaoImplementation oPedidoDao = new PedidoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                    
                    oPedidoBean.setId(oPedidoDao.set(oPedidoBean));
                    
                    Iterator<CarritoSpecificBeanImplementation> iterator = alCarrito.iterator();
                    while (iterator.hasNext()) {
                        CarritoSpecificBeanImplementation oCarritoBean = iterator.next();
                        MetaBeanHelper oProductoBeanDeCarritoConMetaDatos = oCarritoBean.getObj_producto();
                        ProductoSpecificBeanImplementation oProductoBeanDeCarrito = (ProductoSpecificBeanImplementation) oProductoBeanDeCarritoConMetaDatos.getBean();
                        ProductoSpecificDaoImplementation oProductoDao = new ProductoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                        MetaBeanHelper oMetaBeanHelper = (MetaBeanHelper) oProductoDao.get(oProductoBeanDeCarrito.getId(), ConfigurationConstants.jsonMsgDepth);
                        ProductoSpecificBeanImplementation oProductoBeanDeDB = (ProductoSpecificBeanImplementation) oMetaBeanHelper.getBean();
                        if (oProductoBeanDeDB.getExistencias() > oCarritoBean.getCantidad()) {
                            LineapedidoSpecificBeanImplementation oLineadepedidoBean = new LineapedidoSpecificBeanImplementation();
                            TicketSpecificBeanImplementation oTicketdepedidoBean = new TicketSpecificBeanImplementation();

                            oLineadepedidoBean.setCantidad(oCarritoBean.getCantidad());
                            oLineadepedidoBean.setId_pedido(oPedidoBean.getId());
                            oLineadepedidoBean.setId_producto(oProductoBeanDeCarrito.getId());

                            //oTicketdepedidoBean.setFecha_ticket(oPedidoBean.getFecha_pedido());
                            oTicketdepedidoBean.setId_pedido(oPedidoBean.getId());

                            LineapedidoSpecificDaoImplementation oLineadepedidoDao = new LineapedidoSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                            oLineadepedidoBean.setId(oLineadepedidoDao.set(oLineadepedidoBean));
                            oProductoBeanDeCarrito.setExistencias(oProductoBeanDeCarrito.getExistencias() - oCarritoBean.getCantidad());

                            TicketSpecificDaoImplementation oTicketdepedidoDao = new TicketSpecificDaoImplementation(oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                            oTicketdepedidoBean.setId(oTicketdepedidoDao.set(oTicketdepedidoBean));

                            oProductoDao.set(oProductoBeanDeCarrito);
                        }
                    }
                    alCarrito.clear();
                    oConnection.commit();
                }
            } catch (Exception ex) {
                oConnection.rollback();
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }
            return oReplyBean = new ReplyBeanHelper(200, "Compra realizada correctamente");
        } else {
            return new ReplyBeanHelper(401, "Unauthorized operation");
        }
    }

    public ReplyBeanHelper empty() throws Exception {
        if (this.checkPermission("empty")) {
            ArrayList<CarritoSpecificBeanImplementation> alCarrito = (ArrayList) oRequest.getSession().getAttribute("carrito");
            ReplyBeanHelper oReplyBean = null;
            alCarrito.clear();
            Gson oGson = GsonHelper.getGson();
            String strJson = oGson.toJson(alCarrito);
            oReplyBean = new ReplyBeanHelper(200, strJson);
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, "Unauthorized operation");
        }
}

}
