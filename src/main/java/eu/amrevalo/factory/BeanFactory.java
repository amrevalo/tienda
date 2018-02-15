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
import eu.amrevalo.bean.publicinterface.GenericBeanInterface;
import eu.amrevalo.bean.specificimplementation.AutorSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.ClienteSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.FacturaSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.GeneroSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.ImagenSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.LineapedidoSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.PedidoSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.ProductoSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.ProdxproveedorSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.ProveedorSpecificBeanImplementation;
import eu.amrevalo.bean.specificimplementation.TipoproductoSpecificBeanImplementation;


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
            case "autor":
                oBean = new AutorSpecificBeanImplementation();
                break;
            case "genero":
                oBean = new GeneroSpecificBeanImplementation();
                break;
            case "imagen":
                oBean = new ImagenSpecificBeanImplementation();
                break;
            case "proveedor":
                oBean = new ProveedorSpecificBeanImplementation();
                break;  
            case "prodxproveedor":
                oBean = new ProdxproveedorSpecificBeanImplementation();
                break;
            case "cliente":
                oBean = new ClienteSpecificBeanImplementation();
                break;
            case "pedido":
                oBean = new PedidoSpecificBeanImplementation();
                break;
            case "factura":
                oBean = new FacturaSpecificBeanImplementation();
                break;
            case "lineapedido":
                oBean = new LineapedidoSpecificBeanImplementation();
                break;
                        
            default:

                //  oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oBean;
    }
}
