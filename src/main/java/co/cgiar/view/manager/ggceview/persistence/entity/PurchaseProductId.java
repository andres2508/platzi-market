package co.cgiar.view.manager.ggceview.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PurchaseProductId implements Serializable {
    @Column(name = "id_compra")
    private Integer purchaseId;
    @Column(name = "id_producto")
    private Integer productId;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
