package co.cgiar.view.manager.ggceview.domain.app;

import co.cgiar.view.manager.ggceview.domain.ProductReadView;
import co.cgiar.view.manager.ggceview.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public ResponseEntity<List<ProductReadView>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductReadView> getProduct(@PathVariable("id") int productId) {
        return service.getProduct(productId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductReadView>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return service.getByCategory(categoryId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<ProductReadView> save(@RequestBody ProductReadView product) {
        return new ResponseEntity<>(service.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("productId") int productId) {
        if (service.delete(productId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
