package co.cgiar.view.manager.ggceview.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class Client {
    @Id
    private String id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellidos")
    private String lastname;
    @Column(name = "celular")
    private Integer phone;
    @Column(name = "direccion")
    private String address;
    @Column(name = "correo_electronico")
    private String mailAddress;
    @OneToMany(mappedBy = "client")
    private List<Purchase> purchases;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}
