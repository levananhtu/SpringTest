package com.lvat.SpringTest.accessingdatamysql.entities;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "product_lines")
@Entity(name = "ProductLines")
public class ProductLines {
    @Id
    @Column(name = "product_line", nullable = false)
    private String productLine;

    @Column(name = "text_description")
    private String textDescription;

    @Column(name = "html_description")
    private String htmlDescription;

    @Column(name = "image")
    private Byte[] image;

    @OneToMany(targetEntity = Products.class)
//    @JoinColumn(referencedColumnName = "product_line", name = "product_line", insertable = false, updatable = false)
    @JoinColumn(referencedColumnName = "product_line", name = "product_line")
    private Collection<Products> productsCollection;

    public ProductLines() {
    }

    public ProductLines(String productLine, String textDescription, String htmlDescription, Byte[] image) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
        this.image = image;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }
}
