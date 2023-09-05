package co.cgiar.view.manager.ggceview.persistence;

import co.cgiar.view.manager.ggceview.domain.ProductReadView;
import co.cgiar.view.manager.ggceview.domain.repository.ProductViewRepository;
import co.cgiar.view.manager.ggceview.persistence.crud.ProductCrudRepository;
import co.cgiar.view.manager.ggceview.persistence.entity.Product;
import co.cgiar.view.manager.ggceview.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductViewRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;

    public List<ProductReadView> getAll() {
        final var products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProductsView(products);
    }

    @Override
    public Optional<List<ProductReadView>> getAllByCategory(int categoryId) {
        final var products = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProductsView(products));
    }

    @Override
    public Optional<List<ProductReadView>> getScarceProducts(int quantity) {
        final var scarceProducts = productCrudRepository.findByStockQuantityLessThanAndState(quantity, true);
        return scarceProducts.map(it -> mapper.toProductsView(it));
    }

    public Optional<ProductReadView> getProduct(int productId) {
        final var found = productCrudRepository.findById(productId);
        return found.map(product -> mapper.toReadView(product));
    }

    @Override
    public ProductReadView save(ProductReadView product) {
        final var model = mapper.toProduct(product);
        return mapper.toReadView(productCrudRepository.save(model));
    }

    public Product save(Product product) {
        return productCrudRepository.save(product);
    }

    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
