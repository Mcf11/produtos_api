package com.example.produtosapi.model;

// Importando o Javax das versões mais recentes, vem do start-data-jpa, mapeamento:
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;                  // Gera o id automaticamente

// POJO - Plain Old Java Object
// Velho e bom objeto Java, com getters and setters para manipulação


@Entity
@Table(name="produto")
public class Produto {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Representação string do objeto, necessário caso queira printá-lo
    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
