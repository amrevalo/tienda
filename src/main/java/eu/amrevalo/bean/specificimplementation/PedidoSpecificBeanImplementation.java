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
package eu.amrevalo.bean.specificimplementation;

import com.google.gson.annotations.Expose;
import eu.amrevalo.bean.genericimplementation.TableGenericBeanImplementation;
import eu.amrevalo.bean.helper.MetaBeanHelper;
import eu.amrevalo.bean.meta.publicinterface.MetaObjectBeanInterface;
import eu.amrevalo.bean.meta.publicinterface.MetaPropertyBeanInterface;
import eu.amrevalo.helper.EnumHelper;
import eu.amrevalo.helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "pedido",
        SingularDescription = "Pedido",
        PluralDescription = "Pedidos",
        Icon = "fa fa-file",
        Type = EnumHelper.SourceType.Table
)
public class PedidoSpecificBeanImplementation extends TableGenericBeanImplementation {


    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_cliente = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Cliente",
            LongName = "Cliente del pedido",
            Description = "Cliente del pedido",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "cliente",
            Width = 4
    )
    private MetaBeanHelper obj_cliente = null;
    
    
    
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Pedido",
            LongName = "Pedido del cliente",
            Description = "Pedido del cliente",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = true
    )
    private String descripcion = "";
    
    
    
    
    
    
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Lineas pedido por pedido",
            LongName = "Lineas de pedido por pedido",
            Description = "Lineas de pedido por pedido",
            Type = EnumHelper.FieldType.Link,
            References = "lineapedido"
    )
    private Integer link_lineapedido = null;
    
    
    
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "factura del pedido",
            LongName = "factura del pedido",
            Description = "factura del pedido",
            Type = EnumHelper.FieldType.Link,
            References = "factura"
    )
    private Integer link_factura = null;

    
    public PedidoSpecificBeanImplementation() {
    }

    public PedidoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public MetaBeanHelper getObj_cliente() {
        return obj_cliente;
    }

    public void setObj_cliente(MetaBeanHelper obj_cliente) {
        this.obj_cliente = obj_cliente;
    }

   

    

    

    
}
