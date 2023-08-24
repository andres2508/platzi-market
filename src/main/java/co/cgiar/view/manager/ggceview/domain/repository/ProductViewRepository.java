package co.cgiar.view.manager.ggceview.domain.repository;

import co.cgiar.view.manager.ggceview.domain.ProductReadView;

import java.util.List;
import java.util.Optional;

public interface ProductViewRepository {
    List<ProductReadView> getAll();

    Optional<List<ProductReadView>> getAllByCategory(int categoryId);

    Optional<List<ProductReadView>> getScarceProducts(int quantity);

    Optional<ProductReadView> getProduct(int productId);

    ProductReadView save(ProductReadView product);

    void delete(int productId);
}
