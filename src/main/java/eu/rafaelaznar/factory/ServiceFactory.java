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
package eu.rafaelaznar.factory;

import eu.rafaelaznar.bean.helper.ReplyBeanHelper;
import eu.rafaelaznar.helper.EncodingHelper;
import eu.rafaelaznar.service.specificimplementation.AutorSpecificServiceImplementation;

import eu.rafaelaznar.service.specificimplementation.ClienteSpecificServiceImplementation;
//import eu.rafaelaznar.service.specificimplementation.CursoSpecificServiceImplementation;
//import eu.rafaelaznar.service.specificimplementation.DependenciaSpecificServiceImplementation;

import eu.rafaelaznar.service.specificimplementation.FacturaSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.GeneroSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.ImagenSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.LineapedidoSpecificServiceImplementation;
//import eu.rafaelaznar.service.specificimplementation.GrupoSpecificServiceImplementation;
//import eu.rafaelaznar.service.specificimplementation.MedicoSpecificServiceImplementation;

import eu.rafaelaznar.service.specificimplementation.PedidoSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.ProductoSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.ProdxproveedorSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.ProveedorSpecificServiceImplementation;
//import eu.rafaelaznar.service.specificimplementation.PacienteSpecificServiceImplementation;

import eu.rafaelaznar.service.specificimplementation.TipoproductoSpecificServiceImplementation;

import eu.rafaelaznar.service.specificimplementation.TipousuarioSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.UsuarioSpecificServiceImplementation;
import javax.servlet.http.HttpServletRequest;

public class ServiceFactory {

    public static ReplyBeanHelper executeMethodService(HttpServletRequest oRequest) throws Exception {
        String ob = oRequest.getParameter("ob");
        String op = oRequest.getParameter("op");
        ReplyBeanHelper oReplyBean = null;
        switch (ob) {
            case "usuario":
                UsuarioSpecificServiceImplementation oUsuarioService = new UsuarioSpecificServiceImplementation(oRequest);
                switch (op) {

                    case "getallobjectsmetadata":
                        oReplyBean = oUsuarioService.getallobjectsmetadata();
                        break;
                    case "getmetadata":
                        oReplyBean = oUsuarioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oUsuarioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oUsuarioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oUsuarioService.get();
                        break;
                    case "set":
                        oReplyBean = oUsuarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oUsuarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oUsuarioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oUsuarioService.getCount();
                        break;
                    case "login":
                        oReplyBean = oUsuarioService.login();
                        break;
                    case "logout":
                        oReplyBean = oUsuarioService.logout();
                        break;
                    case "getsessionstatus":
                        oReplyBean = oUsuarioService.getSessionStatus();
                        break;
                    case "getcountx":
                        oReplyBean = oUsuarioService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oUsuarioService.getPageX();
                        break;
                    case "setpass":
                        oReplyBean = oUsuarioService.setPass();
                        break;
                    case "getsessionuserlevel":
                        oReplyBean = oUsuarioService.getSessionUserLevel();
                        break;
                    case "checklogin":
                        oReplyBean = oUsuarioService.checklogin();
                        break;
                    case "setalumno":
                        oReplyBean = oUsuarioService.setalumno();
                        break;
                    case "getidcurso":
                        oReplyBean = oUsuarioService.getidcurso();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "tipousuario":
                TipousuarioSpecificServiceImplementation oTipousuarioService = new TipousuarioSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTipousuarioService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTipousuarioService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTipousuarioService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTipousuarioService.get();
                        break;
                    case "set":
                        oReplyBean = oTipousuarioService.set();
                        break;
                    case "remove":
                        oReplyBean = oTipousuarioService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTipousuarioService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTipousuarioService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
            case "producto":
                ProductoSpecificServiceImplementation oProductoService = new ProductoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oProductoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oProductoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oProductoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oProductoService.get();
                        break;
                    case "set":
                        oReplyBean = oProductoService.set();
                        break;
                    case "remove":
                        oReplyBean = oProductoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oProductoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oProductoService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oProductoService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oProductoService.getPageX();
                        break;    
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
                
                
                case "tipoproducto":
                TipoproductoSpecificServiceImplementation oTipoproductoService = new TipoproductoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oTipoproductoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oTipoproductoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oTipoproductoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oTipoproductoService.get();
                        break;
                    case "set":
                        oReplyBean = oTipoproductoService.set();
                        break;
                    case "remove":
                        oReplyBean = oTipoproductoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oTipoproductoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oTipoproductoService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
                
                case "genero":
                GeneroSpecificServiceImplementation oGeneroService = new GeneroSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oGeneroService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oGeneroService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oGeneroService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oGeneroService.get();
                        break;
                    case "set":
                        oReplyBean = oGeneroService.set();
                        break;
                    case "remove":
                        oReplyBean = oGeneroService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oGeneroService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oGeneroService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
                
                case "autor":
                AutorSpecificServiceImplementation oAutorService = new AutorSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oAutorService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oAutorService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oAutorService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oAutorService.get();
                        break;
                    case "set":
                        oReplyBean = oAutorService.set();
                        break;
                    case "remove":
                        oReplyBean = oAutorService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oAutorService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oAutorService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;        
                
                case "imagen":
                ImagenSpecificServiceImplementation oImagenService = new ImagenSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oImagenService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oImagenService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oImagenService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oImagenService.get();
                        break;
                    case "set":
                        oReplyBean = oImagenService.set();
                        break;
                    case "remove":
                        oReplyBean = oImagenService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oImagenService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oImagenService.getCount();
                        break;
                    case "getcountx":
                        oReplyBean = oImagenService.getCountX();
                        break;
                    case "getpagex":
                        oReplyBean = oImagenService.getPageX();
                        break;    
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
                
                
                case "proveedor":
                ProveedorSpecificServiceImplementation oProveedorService = new ProveedorSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oProveedorService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oProveedorService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oProveedorService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oProveedorService.get();
                        break;
                    case "set":
                        oReplyBean = oProveedorService.set();
                        break;
                    case "remove":
                        oReplyBean = oProveedorService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oProveedorService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oProveedorService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
                
                
                case "prodxproveedor":
                ProdxproveedorSpecificServiceImplementation oProdxproveedorService = new ProdxproveedorSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oProdxproveedorService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oProdxproveedorService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oProdxproveedorService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oProdxproveedorService.get();
                        break;
                    case "set":
                        oReplyBean = oProdxproveedorService.set();
                        break;
                    case "remove":
                        oReplyBean = oProdxproveedorService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oProdxproveedorService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oProdxproveedorService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
                
                
                case "cliente":
                ClienteSpecificServiceImplementation oClienteService = new ClienteSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oClienteService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oClienteService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oClienteService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oClienteService.get();
                        break;
                    case "set":
                        oReplyBean = oClienteService.set();
                        break;
                    case "remove":
                        oReplyBean = oClienteService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oClienteService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oClienteService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
                
                case "pedido":
                PedidoSpecificServiceImplementation oPedidoService = new PedidoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oPedidoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oPedidoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oPedidoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oPedidoService.get();
                        break;
                    case "set":
                        oReplyBean = oPedidoService.set();
                        break;
                    case "remove":
                        oReplyBean = oPedidoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oPedidoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oPedidoService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
                
                
                case "factura":
                FacturaSpecificServiceImplementation oFacturaService = new FacturaSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oFacturaService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oFacturaService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oFacturaService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oFacturaService.get();
                        break;
                    case "set":
                        oReplyBean = oFacturaService.set();
                        break;
                    case "remove":
                        oReplyBean = oFacturaService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oFacturaService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oFacturaService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
                
                
                case "lineapedido":
                LineapedidoSpecificServiceImplementation oLineapedidoService = new LineapedidoSpecificServiceImplementation(oRequest);
                switch (op) {
                    case "getmetadata":
                        oReplyBean = oLineapedidoService.getMetaData();
                        break;
                    case "getobjectmetadata":
                        oReplyBean = oLineapedidoService.getObjectMetaData();
                        break;
                    case "getpropertiesmetadata":
                        oReplyBean = oLineapedidoService.getPropertiesMetaData();
                        break;
                    case "get":
                        oReplyBean = oLineapedidoService.get();
                        break;
                    case "set":
                        oReplyBean = oLineapedidoService.set();
                        break;
                    case "remove":
                        oReplyBean = oLineapedidoService.remove();
                        break;
                    case "getpage":
                        oReplyBean = oLineapedidoService.getPage();
                        break;
                    case "getcount":
                        oReplyBean = oLineapedidoService.getCount();
                        break;
                    default:
                        oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Operation not found : Please contact your administrator"));
                        break;
                }
                break;
                
            default:
                oReplyBean = new ReplyBeanHelper(500, EncodingHelper.quotate("Object not found : Please contact your administrator"));
                break;
        }
        return oReplyBean;
    }
}
