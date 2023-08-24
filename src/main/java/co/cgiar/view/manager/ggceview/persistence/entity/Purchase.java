package co.cgiar.view.manager.ggceview.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Purchase {
    @Id
    @Column(name = "id_compra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_cliente")
    private Integer clientId;
    @Column(name = "fecha")
    private LocalDateTime date;
    @Column(name = "medio_pago")
    private String paymentMethod;
    @Column(name = "comentario")
    private String comment;
    @Column(name = "state")
    private String state;
    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Client client;
    @OneToMany(mappedBy = "purchase")
    private List<PurchaseProduct> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
