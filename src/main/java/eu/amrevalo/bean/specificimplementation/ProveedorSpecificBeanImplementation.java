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
        TableName = "proveedor",
        SingularDescription = "Proveedor",
        PluralDescription = "Proveedores",
        Icon = "fa fa-truck",
        Type = EnumHelper.SourceType.Table
)
public class ProveedorSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Proveedor",
            LongName = "Proveedor del producto",
            Description = "Proveedor del producto",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = true
    )
    private String descripcion = "";

    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Direccion",
            LongName = "Direccion del proveedor",
            Description = "Direccion del proveedor",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            RegexPattern = RegexConstants.direction,
            RegexHelp = RegexConstants.directionSentence_Help,
            IsForeignKeyDescriptor = false
    )
    private String direccion = "";
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Telefono",
            LongName = "Telefono del proveedor",
            Description = "Telefono del proveedor",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            RegexPattern = RegexConstants.phoneNumber,
            RegexHelp = RegexConstants.phoneNumber_Help,
            IsForeignKeyDescriptor = false
    )
    private String telefono = "";
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Email",
            LongName = "Email del proveedor",
            Description = "Email del proveedor",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.email,
            RegexHelp = RegexConstants.email_Help,
            IsForeignKeyDescriptor = false
    )
    private String email = "";
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Codigo postal",
            LongName = "Codigo postal del proveedor",
            Description = "Codigo postal del proveedor",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            RegexPattern = RegexConstants.postalCode,
            RegexHelp = RegexConstants.postalCode_Help,
            IsForeignKeyDescriptor = false
    )
    private String codigo_postal = "";
    
    
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Producto del proveedor",
            LongName = "Producto del proveedor ",
            Description = "Producto del proveedor",
            Type = EnumHelper.FieldType.Link,
            References = "prodxproveedor"
    )
    private Integer link_prodxproveedor = null;

    public ProveedorSpecificBeanImplementation() {
    }

    public ProveedorSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    
    
    
    
    
    
}
