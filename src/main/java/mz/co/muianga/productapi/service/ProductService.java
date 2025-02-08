package mz.co.muianga.productapi.service;

import lombok.AllArgsConstructor;
import mz.co.muianga.productapi.converter.DTOConverter;
import mz.co.muianga.productapi.model.Product;
import mz.co.muianga.productapi.repository.CategoryRepository;
import mz.co.muianga.productapi.repository.ProductRepository;
import mz.co.muianga.shoppingclient.dto.ProductDTO;
import mz.co.muianga.shoppingclient.exception.CategoryNotFoundException;
import mz.co.muianga.shoppingclient.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream()
                .map(DTOConverter::convert)
                .toList();
    }

    public List<ProductDTO> findByCategoryId(Long categoryId) {
        return productRepository.getProductByCategory(categoryId).stream()
                .map(DTOConverter::convert)
                .toList();
    }

    public ProductDTO findByProductIdentifier(String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return DTOConverter.convert(product);
        }

        throw new ProductNotFoundException();
    }

    public ProductDTO save(ProductDTO productDTO) {
        var existsCategory = categoryRepository.existsById(productDTO.getCategory().getId());
        if (!existsCategory) {
            throw new CategoryNotFoundException();
        }

        Product product = productRepository.save(DTOConverter.convert(productDTO));
        return DTOConverter.convert(product);
    }

    public void delete(Long id) {
        var product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        productRepository.delete(product);
    }
}
