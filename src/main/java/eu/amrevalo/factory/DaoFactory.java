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
package eu.amrevalo.factory;

import eu.amrevalo.bean.helper.MetaBeanHelper;
import eu.amrevalo.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.amrevalo.dao.publicinterface.MetaDaoInterface;
import eu.amrevalo.dao.specificimplementation.AutorSpecificDaoImplementation;
import eu.amrevalo.dao.specificimplementation.ClienteSpecificDaoImplementation;
import eu.amrevalo.dao.specificimplementation.FacturaSpecificDaoImplementation;
import eu.amrevalo.dao.specificimplementation.GeneroSpecificDaoImplementation;
import eu.amrevalo.dao.specificimplementation.ImagenSpecificDaoImplementation;
import eu.amrevalo.dao.specificimplementation.LineapedidoSpecificDaoImplementation;
import eu.amrevalo.dao.specificimplementation.PedidoSpecificDaoImplementation;
import eu.amrevalo.dao.specificimplementation.ProductoSpecificDaoImplementation;
import eu.amrevalo.dao.specificimplementation.ProdxproveedorSpecificDaoImplementation;
import eu.amrevalo.dao.specificimplementation.ProveedorSpecificDaoImplementation;
import eu.amrevalo.dao.specificimplementation.TipoproductoSpecificDaoImplementation;
import eu.amrevalo.dao.specificimplementation.TipousuarioSpecificDaoImplementation;
import eu.amrevalo.dao.specificimplementation.UsuarioSpecificDaoImplementation;
import java.sql.Connection;

public class DaoFactory {

    public static MetaDaoInterface getDao(String ob, Connection oConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        MetaDaoInterface oDao = null;
        switch (ob) {
            case "usuario":
               if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    oDao = (MetaDaoInterface) new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
//                        case 3:
//                            oDao = (MetaDaoInterface) new UsuarioProfesorSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                            break;
//                        case 4:
//                            oDao = (MetaDaoInterface) new UsuarioAlumnoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
//                            break;
                        case 5:
                            oDao = (MetaDaoInterface) new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                    }
                }
                break;
            case "tipousuario":
                oDao = (MetaDaoInterface) new TipousuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            
            case "producto":
                oDao = (MetaDaoInterface) new ProductoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;    
             
            case "tipoproducto":
                oDao = (MetaDaoInterface) new TipoproductoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
                
            case "genero":
                oDao = (MetaDaoInterface) new GeneroSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
                
            case "autor":
                oDao = (MetaDaoInterface) new AutorSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
            
            case "imagen":
                oDao = (MetaDaoInterface) new ImagenSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
                
            case "proveedor":
                oDao = (MetaDaoInterface) new ProveedorSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
                
            case "prodxproveedor":
                oDao = (MetaDaoInterface) new ProdxproveedorSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
                
            case "cliente":
                oDao = (MetaDaoInterface) new ClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                break;
                
            case "pedido":
               oDao = (MetaDaoInterface) new PedidoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
               break;
               
            case "lineapedido":
               oDao = (MetaDaoInterface) new LineapedidoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
               break;
               
            case "factura":
               oDao = (MetaDaoInterface) new FacturaSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
               break;   
                
            default:
                //oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oDao;
    }

}
