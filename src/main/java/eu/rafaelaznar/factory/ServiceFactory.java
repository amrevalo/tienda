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
import eu.rafaelaznar.service.specificimplementation.CategoriaprofesionalSpecificServiceImplementation;
//import eu.rafaelaznar.service.specificimplementation.CentroSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.CentrosanitarioSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.TipoepisodioSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.CircunstanciasaltaSpecificServiceImplementation;
//import eu.rafaelaznar.service.specificimplementation.CursoSpecificServiceImplementation;
//import eu.rafaelaznar.service.specificimplementation.DependenciaSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.EspecialidadSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.DestinoaltaSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.EpisodioSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.FacturaSpecificServiceImplementation;
//import eu.rafaelaznar.service.specificimplementation.GrupoSpecificServiceImplementation;
//import eu.rafaelaznar.service.specificimplementation.MedicoSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.ModalidadepisodioSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.ProductoSpecificServiceImplementation;
//import eu.rafaelaznar.service.specificimplementation.PacienteSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.ServicioSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.TipopagoSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.SexoSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.TipodependenciaSpecificServiceImplementation;
import eu.rafaelaznar.service.specificimplementation.TiposervicioSpecificServiceImplementation;
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
