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
        TableName = "prodxproveedor",
        SingularDescription = "Producto por proveedor",
        PluralDescription = "Productos por proveedor",
        Icon = "fa fa-user-o",
        Type = EnumHelper.SourceType.Table
)
public class ProdxproveedorSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Producto por proveedor",
            LongName = "Producto por proveedor",
            Description = "Producto por proveedor",
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
    private Integer id_proveedor = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Proveedor",
            LongName = "Proveedor",
            Description = "Proveedor",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "proveedor",
            Width = 4
    )
    private MetaBeanHelper obj_proveedor = null;
    
    
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_producto = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Producto",
            LongName = "Producto",
            Description = "Producto",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "producto",
            Width = 4
    )
    private MetaBeanHelper obj_producto = null;
    
//    @Expose(deserialize = false)
//    @MetaPropertyBeanInterface(
//            ShortName = "Mangas del autor",
//            LongName = "Mangas del autor",
//            Description = "Mangas del autor",
//            Type = EnumHelper.FieldType.Link,
//            References = "producto"
//    )
//    private Integer link_producto = null;

    public ProdxproveedorSpecificBeanImplementation() {
    }

    public ProdxproveedorSpecificBeanImplementation(Integer id) {
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

    
    
    
    
}
