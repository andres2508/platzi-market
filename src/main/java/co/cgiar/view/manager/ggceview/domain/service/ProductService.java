package co.cgiar.view.manager.ggceview.domain.service;

import co.cgiar.view.manager.ggceview.domain.ProductReadView;
import co.cgiar.view.manager.ggceview.domain.repository.ProductViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductViewRepository productViewRepository;

    public List<ProductReadView> getAll() {
        return productViewRepository.getAll();
    }

    public Optional<ProductReadView> getProduct(int productId) {
        return productViewRepository.getProduct(productId);
    }

    public Optional<List<ProductReadView>> getByCategory(int categoryId) {
        return productViewRepository.getAllByCategory(categoryId);
    }

    public ProductReadView save(ProductReadView product) {
        return productViewRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(it -> {
            productViewRepository.delete(it.getProductId());
            return true;
        }).orElse(false);
    }
}
