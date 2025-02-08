package mz.co.muianga.productapi.exception;

import mz.co.muianga.shoppingclient.dto.ErrorDTO;
import mz.co.muianga.shoppingclient.exception.CategoryNotFoundException;
import mz.co.muianga.shoppingclient.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
public class ProductControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleProductNotFound(ProductNotFoundException e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("Produto nao encontrado");
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setTimestamp(new Date());

        return errorDTO;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorDTO handleCategoryNotFound(CategoryNotFoundException e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("categoria nao encontrada");
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setTimestamp(new Date());

        return errorDTO;
    }
}
