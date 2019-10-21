package com.lvat.SpringTest.accessingdatamysql.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "product_lines")
@Entity(name = "product_lines")
public class ProductLines {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private Byte[] image;

    public ProductLines() {
    }

    public ProductLines(String productLine, String textDescription, String htmlDescription, Byte[] image) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
        this.image = image;
    }

    public ProductLines(String textDescription, String htmlDescription, Byte[] image) {
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
}
