package com.csci318.onlineorder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private Long id;
    private String supplier;
    private String product;
    private String quantity;

    public Orders() {
    }

    public Orders(String supplier, String product, String quantity) {
        this.supplier = supplier;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", supplier='" + supplier + '\'' +
                ", product='" + product + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Orders))
            return false;
        Orders Orders = (Orders) o;
        return Objects.equals(this.id, Orders.id)
                && Objects.equals(this.supplier, Orders.supplier)
                && Objects.equals(this.product, Orders.product)
                && Objects.equals(this.quantity, Orders.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.supplier, this.product, this.quantity);
    }
}
