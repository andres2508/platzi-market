package co.cgiar.view.manager.ggceview.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Category {
    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "estado")
    private Boolean state;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
