package co.cgiar.view.manager.ggceview.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_producto")
public class PurchaseProduct {
    @EmbeddedId
    private PurchaseProductId id;
    @Column(name = "cantidad")
    private Integer quantity;
    private Double total;
    @Column(name = "estado")
    private Boolean state;
    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Purchase purchase;
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;

    public PurchaseProductId getId() {
        return id;
    }

    public void setId(PurchaseProductId id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
