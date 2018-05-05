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
import java.util.Date;

@MetaObjectBeanInterface(
        TableName = "factura",
        SingularDescription = "Factura",
        PluralDescription = "Facturas",
        Icon = "fa fa-file-archive-o",
        Type = EnumHelper.SourceType.Table
)
public class FacturaSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Descripción",
            LongName = "Descripción",
            Description = "Descripción de la factura",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = true,
            Width = 3,
            MaxLength = 100
    )
    private String descripcion;


    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Importe",
            LongName = "Importe de la factura",
            Description = "Importe de la factura del pedido",
            Type = EnumHelper.FieldType.Decimal,
            IsRequired = true,
            RegexPattern = "^[0-9]+([.][0-9]{2})?$",
            RegexHelp = "Introduce un numero si es con decimales separado por punto y solo dos digitos ",
            IsForeignKeyDescriptor = false,
            MaxLength = 8
    )
    private Double importe;
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Fecha",
            LongName = "Fecha de factura",
            Description = "Fecha de la factura",
            Type = EnumHelper.FieldType.Date,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100
    )
    private Date fecha_factura;

    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "forma pago",
            LongName = "forma de pago",
            Description = "Forma de pago del pedido",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100
    )
    private String forma_pago;
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "observaciones",
            LongName = "observaciones del pedido",
            Description = "observaciones del pedido",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            RegexPattern = RegexConstants.capitalizedName,
            RegexHelp = RegexConstants.capitalizedName_Help,
            IsForeignKeyDescriptor = false,
            IsVisible = false,
            Width = 3,
            MaxLength = 100
    )
    private String observaciones;

    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "IVA",
            LongName = "IVA del pedido",
            Description = "IVA del pedido",
            Type = EnumHelper.FieldType.Integer,
            IsRequired = true,
            RegexPattern = "^[0-9]+$",
            RegexHelp = "Introduce un numero entero para el iva",
            IsForeignKeyDescriptor = false,
            MaxLength = 6
    )
    private Integer iva;
    
    
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
    
    
    
    
    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }


    public Date getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(Date fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
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
    
    
    

}
