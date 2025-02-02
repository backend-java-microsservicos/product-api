package mz.co.muianga.productapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import mz.co.muianga.productapi.model.Product;

@Getter
@Setter
public class ProductDTO {

    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String nome;
    @NotNull
    private Float preco;
    @NotBlank
    private String descricao;
    @NotNull
    private CategoryDTO category;


}
