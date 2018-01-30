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

import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.UsuarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.publicinterface.GenericBeanInterface;
import eu.rafaelaznar.bean.specificimplementation.ApellidoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.AutorSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.CategoriaprofesionalSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.CentroSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.CentrosanitarioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.TipoepisodioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.CircunstanciasaltaSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.CursoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.DependenciaSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.EspecialidadSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.DestinoaltaSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.EpisodioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.FacturaSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.GeneroSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.GrupoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.MedicoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.ModalidadepisodioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.MunicipioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.NombrefemeninoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.NombremasculinoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.PacienteSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.PacienteVisitanteSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.ProductoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.ProvinciaSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.ServicioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.TipopagoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.SexoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.TipodependenciaSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.TipoproductoSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.TiposervicioSpecificBeanImplementation;
import eu.rafaelaznar.bean.specificimplementation.ViaSpecificBeanImplementation;

public class BeanFactory {

    public static GenericBeanInterface getBean(String ob, MetaBeanHelper oPuserBean_security) {
        GenericBeanInterface oBean = null;
        MetaBeanHelper oPuserSecurity = oPuserBean_security;
        switch (ob) {
            case "usuario":
                oBean = new UsuarioSpecificBeanImplementation();
                break;
            case "tipousuario":
                oBean = new TipousuarioSpecificBeanImplementation();
                break;
            case "producto":
                oBean = new ProductoSpecificBeanImplementation();
                break;
            case "tipoproducto":
                oBean = new TipoproductoSpecificBeanImplementation();
                break;
//            case "lineapedido":
//                oBean = new LineapedidoSpecificBeanImplementation();
//                break;
//            case "pedido":
//                oBean = new PedidoSpecificBeanImplementation();
//                break;
//            case "factura":
//                oBean = new FacturaSpecificBeanImplementation();
//                break;
//            case "cliente":
//                oBean = new ClienteSpecificBeanImplementation();
//                break;
            case "autor":
                oBean = new AutorSpecificBeanImplementation();
                break;
            case "genero":
                oBean = new GeneroSpecificBeanImplementation();
                break;
//            case "imagen":
//                oBean = new ImagenSpecificBeanImplementation();
//                break;
//            case "prodxproveedor":
//                oBean = new ProdxproveedorSpecificBeanImplementation();
//                break;
//            case "proveedor":
//                oBean = new ProveedorSpecificBeanImplementation();
//                break;          
            default:

                //  oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oBean;
    }
}
