package mz.co.muianga.productapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mz.co.muianga.productapi.converter.DTOConverter;
import mz.co.muianga.productapi.dto.CategoryDTO;
import mz.co.muianga.productapi.dto.ProductDTO;

@Entity(name = "product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Float preco;
    private String descricao;
    @Column(name = "product_identifier")
    private String productIdentifier;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
