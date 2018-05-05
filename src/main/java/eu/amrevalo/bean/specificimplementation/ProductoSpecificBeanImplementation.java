/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.amrevalo.bean.specificimplementation;

import com.google.gson.annotations.Expose;
import eu.amrevalo.bean.genericimplementation.TableGenericBeanImplementation;
import eu.amrevalo.bean.helper.MetaBeanHelper;
import eu.amrevalo.bean.meta.publicinterface.MetaObjectBeanInterface;
import eu.amrevalo.bean.meta.publicinterface.MetaPropertyBeanInterface;
import eu.amrevalo.helper.EnumHelper;
import eu.amrevalo.helper.constant.RegexConstants;

/**
 *
 * @author a0y3770325h
 */
@MetaObjectBeanInterface(
        TableName = "producto",
        SingularDescription = "Producto",
        PluralDescription = "Productos",
        Icon = "fa fa-github-alt",
        Type = EnumHelper.SourceType.Table
)
public class ProductoSpecificBeanImplementation extends TableGenericBeanImplementation {

    
    
    
    
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_usuario = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Usuario asociado",
            LongName = "Usuario asociado",
            Description = "Usuario del producto creado",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "usuario",
            Width = 4,
            IsVisible = false
    )
    private MetaBeanHelper obj_usuario = null;
    
    
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_tipoproducto = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Tipo",
            LongName = "Tipo producto",
            Description = "Tipo de producto",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "tipoproducto",
            Width = 4
    )
    private MetaBeanHelper obj_tipoproducto = null;
    
    
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_genero = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Genero",
            LongName = "Genero del manga",
            Description = "Genero del manga",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            IsVisible = false,
            References = "genero",
            Width = 4
    )
    private MetaBeanHelper obj_genero = null;
    
    
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_autor = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Autor",
            LongName = "Autor del manga",
            Description = "Autor del manga",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "autor",
            Width = 4
    )
    private MetaBeanHelper obj_autor = null;
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Producto",
            LongName = "Producto",
            Description = "Nombre del Producto",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = true
    )
    private String descripcion = "";
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Cod.",
            LongName = "Código",
            Description = "Código del producto",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            RegexPattern = "^[A-Z]+[0-9]{4}",
            RegexHelp = "Primera letra mayuscula seguido de 4 numeros",
            IsForeignKeyDescriptor = false,
            IsVisible = false,
            MaxLength = 50
    )
    private String codigo;
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Existencias",
            LongName = "Existencias del producto",
            Description = "Existencias del producto",
            Type = EnumHelper.FieldType.Integer,
            IsRequired = true,
            RegexPattern = "^[0-9]+$",
            RegexHelp = "Introduce un numero entero ",
            IsForeignKeyDescriptor = false,
            MaxLength = 6
    )
    private Integer existencias;
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Precio",
            LongName = "Precio del producto",
            Description = "Precio del producto",
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
            ShortName = "Fabricante/editorial",
            LongName = "Fabricante/editorial del producto",
            Description = "Fabricante o editorial del producto",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = false,
            IsVisible = false
    )
    private String fabricanteoeditorial = "";
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Publico",
            LongName = "Publico del producto",
            Description = "Publico al que va el producto",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            RegexPattern = "^[+]+[0-9]{1,2}",
            RegexHelp = "Introduce el signo + seguido de uno o dos numeros ",
            IsForeignKeyDescriptor = false,
            IsVisible = false
    )
    private String publico = "";
    
    
    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Informacion Adicional",
            LongName = "Informacion adicional del producto",
            Description = "Informacion adicional del producto",
            Type = EnumHelper.FieldType.String,
            IsRequired = false,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = false,
            IsVisible = false
    )
    private String informacion_adicional = "";

    
    
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Imagenes del producto",
            LongName = "Imagenes del producto",
            Description = "Imagenes del producto",
            Type = EnumHelper.FieldType.Link,
            References = "imagen"
    )
    private Integer link_imagen = null;
    
    
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Producto por proveedor",
            LongName = "Producto por proveedor",
            Description = "Producto por proveedor",
            Type = EnumHelper.FieldType.Link,
            References = "prodxproveedor"
    )
    private Integer link_prodxproveedor = null;
    
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Lineas pedido del producto",
            LongName = "Lineas de pedido donde esta el producto",
            Description = "Lineas de pedido donde esta el producto",
            Type = EnumHelper.FieldType.Link,
            References = "lineapedido"
    )
    private Integer link_lineapedido = null;
    
    
    public ProductoSpecificBeanImplementation() {
    }

    ProductoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }


    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFabricanteoeditorial() {
        return fabricanteoeditorial;
    }

    public void setFabricanteoeditorial(String fabricanteoeditorial) {
        this.fabricanteoeditorial = fabricanteoeditorial;
    }

    public String getPublico() {
        return publico;
    }

    public void setPublico(String publico) {
        this.publico = publico;
    }

    public String getInformacion_adicional() {
        return informacion_adicional;
    }

    public void setInformacion_adicional(String informacion_adicional) {
        this.informacion_adicional = informacion_adicional;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public MetaBeanHelper getObj_usuario() {
        return obj_usuario;
    }

    public void setObj_usuario(MetaBeanHelper obj_usuario) {
        this.obj_usuario = obj_usuario;
    }

    public Integer getId_tipoproducto() {
        return id_tipoproducto;
    }

    public void setId_tipoproducto(Integer id_tipoproducto) {
        this.id_tipoproducto = id_tipoproducto;
    }

    public MetaBeanHelper getObj_tipoproducto() {
        return obj_tipoproducto;
    }

    public void setObj_tipoproducto(MetaBeanHelper obj_tipoproducto) {
        this.obj_tipoproducto = obj_tipoproducto;
    }

    public Integer getId_genero() {
        return id_genero;
    }

    public void setId_genero(Integer id_genero) {
        this.id_genero = id_genero;
    }

    public MetaBeanHelper getObj_genero() {
        return obj_genero;
    }

    public void setObj_genero(MetaBeanHelper obj_genero) {
        this.obj_genero = obj_genero;
    }

    public Integer getId_autor() {
        return id_autor;
    }

    public void setId_autor(Integer id_autor) {
        this.id_autor = id_autor;
    }

    public MetaBeanHelper getObj_autor() {
        return obj_autor;
    }

    public void setObj_autor(MetaBeanHelper obj_autor) {
        this.obj_autor = obj_autor;
    }
    
    
    
    
}
