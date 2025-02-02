package mz.co.muianga.productapi.service;

import mz.co.muianga.productapi.converter.DTOConverter;
import mz.co.muianga.productapi.dto.ProductDTO;
import mz.co.muianga.productapi.model.Product;
import mz.co.muianga.productapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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

        return null;
    }

    public ProductDTO save(ProductDTO productDTO) {
        Product product = productRepository.save(Product.convert(productDTO));
        return DTOConverter.convert(product);
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.delete(product);
        }

    }
}
