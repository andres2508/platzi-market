package co.cgiar.view.manager.ggceview.persistence.crud;

import co.cgiar.view.manager.ggceview.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    List<Product> findByCategoryIdOrderByNameAsc(int categoryId);

    Optional<List<Product>> findByStockQuantityLessThanAndState(int quantity, boolean state);
}
