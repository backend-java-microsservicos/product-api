package mz.co.muianga.productapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import mz.co.muianga.productapi.model.Category;

@Getter
@Setter
public class CategoryDTO {

    @NotNull
    private Long id;
    private String nome;


}
