package co.cgiar.view.manager.ggceview.domain.app;

import co.cgiar.view.manager.ggceview.domain.ProductReadView;
import co.cgiar.view.manager.ggceview.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    public List<ProductReadView> getAll() {
        return service.getAll();
    }

    public Optional<ProductReadView> getProduct(int productId) {
        return service.getProduct(productId);
    }

    public Optional<List<ProductReadView>> getByCategory(int categoryId) {
        return service.getByCategory(categoryId);
    }

    public ProductReadView save(ProductReadView product) {
        return service.save(product);
    }

    public boolean delete(int productId) {
        return service.delete(productId);
    }
}
