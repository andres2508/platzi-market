package co.cgiar.view.manager.ggceview.persistence.mapper;

import co.cgiar.view.manager.ggceview.domain.ProductReadView;
import co.cgiar.view.manager.ggceview.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "category", target = "category")
    })
    ProductReadView toReadView(Product product);

    List<ProductReadView> toProductsView(List<Product> products);

    @InheritInverseConfiguration()
    @Mapping(target = "barcode", ignore = true)
    Product toProduct(ProductReadView product);
}
