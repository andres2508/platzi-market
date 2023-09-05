package co.cgiar.view.manager.ggceview.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "id_categoria")
    private Integer categoryId;
    @Column(name = "codigo_barras")
    private String barcode;
    @Column(name = "precio_venta")
    private Double price;
    @Column(name = "cantidad_stock")
    private Integer stockQuantity;
    @Column(name = "estado")
    private Boolean state;
    @ManyToOne()
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Category category;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
