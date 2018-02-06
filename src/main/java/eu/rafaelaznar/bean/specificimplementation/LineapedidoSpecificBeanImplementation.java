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
package eu.rafaelaznar.bean.specificimplementation;

import com.google.gson.annotations.Expose;
import eu.rafaelaznar.bean.genericimplementation.TableGenericBeanImplementation;
import eu.rafaelaznar.bean.helper.MetaBeanHelper;
import eu.rafaelaznar.bean.meta.publicinterface.MetaObjectBeanInterface;
import eu.rafaelaznar.bean.meta.publicinterface.MetaPropertyBeanInterface;
import eu.rafaelaznar.helper.EnumHelper;
import eu.rafaelaznar.helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "lineapedido",
        SingularDescription = "Linea de pedido",
        PluralDescription = "Lineas de pedido",
        Icon = "fas fa-camera-retro",
        Type = EnumHelper.SourceType.Table
)
public class LineapedidoSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Linea Pedido",
            LongName = "Linea de Pedido",
            Description = "Linea de Pedido",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = true
    )
    private String descripcion = "";

    
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_producto = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Producto",
            LongName = "Producto de linea pedido",
            Description = "Producto de la linea de pedido",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "producto",
            Width = 4
    )
    private MetaBeanHelper obj_producto = null;
    
    
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_pedido = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Pedido",
            LongName = "Pedido",
            Description = "Identificador de pedido",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "pedido",
            Width = 4
    )
    private MetaBeanHelper obj_pedido = null;
    
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Precio",
            LongName = "Precio",
            Description = "Precio del producto o productos de la linea de pedido",
            Type = EnumHelper.FieldType.Decimal,
            IsRequired = true,
            RegexPattern = "^[0-9]+([.][0-9]{2})?$",
            RegexHelp = "Introduce un numero ",
            IsForeignKeyDescriptor = false,
            MaxLength = 8
    )
    private Double precio;
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Cantidad",
            LongName = "Cantidad del producto",
            Description = "Cantidad del mismo producto",
            Type = EnumHelper.FieldType.Integer,
            IsRequired = true,
            RegexPattern = "^[0-9]+$",
            RegexHelp = "Introduce un numero entero ",
            IsForeignKeyDescriptor = false,
            MaxLength = 6
    )
    private Integer cantidad;
    
    


    public LineapedidoSpecificBeanImplementation() {
    }

    public LineapedidoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public MetaBeanHelper getObj_producto() {
        return obj_producto;
    }

    public void setObj_producto(MetaBeanHelper obj_producto) {
        this.obj_producto = obj_producto;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public MetaBeanHelper getObj_pedido() {
        return obj_pedido;
    }

    public void setObj_pedido(MetaBeanHelper obj_pedido) {
        this.obj_pedido = obj_pedido;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    

    

    

    
}
