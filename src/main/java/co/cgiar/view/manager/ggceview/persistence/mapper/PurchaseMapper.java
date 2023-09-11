package co.cgiar.view.manager.ggceview.persistence.mapper;

import co.cgiar.view.manager.ggceview.domain.PurchaseReadView;
import co.cgiar.view.manager.ggceview.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "id", target = "purchaseId"),
            @Mapping(source = "products", target = "items")
    })
    PurchaseReadView toReadView(Purchase purchase);

    List<PurchaseReadView> toPurchases(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "client", ignore = true)
    })
    Purchase toPurchase(PurchaseReadView readView);
}
