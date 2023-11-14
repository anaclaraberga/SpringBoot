package br.com.fag.springboot.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUCTS")

public class ProductModel implements Serializable{
  private static final long serialVersionUID = 1L;
    
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private UUID idProduct;
  private String name;
  private BigDecimal value;

    /**
     * @return UUID return the idProduct
     */
    public UUID getIdProduct() {
        return idProduct;
    }

    /**
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return BigDecimal return the value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
