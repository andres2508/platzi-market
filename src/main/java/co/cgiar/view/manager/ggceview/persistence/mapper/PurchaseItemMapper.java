package co.cgiar.view.manager.ggceview.persistence.mapper;

import co.cgiar.view.manager.ggceview.domain.PurchaseItemReadView;
import co.cgiar.view.manager.ggceview.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "state", target = "active")
    })
    PurchaseItemReadView toPurchaseView(PurchaseProduct product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.purchaseId", ignore = true)
    })
    PurchaseProduct toPurchaseProduct(PurchaseItemReadView item);
}
