package co.cgiar.view.manager.ggceview.persistence;

import co.cgiar.view.manager.ggceview.domain.PurchaseReadView;
import co.cgiar.view.manager.ggceview.domain.repository.PurchaseViewRepository;
import co.cgiar.view.manager.ggceview.persistence.crud.PurchaseCrudRepository;
import co.cgiar.view.manager.ggceview.persistence.entity.Purchase;
import co.cgiar.view.manager.ggceview.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements PurchaseViewRepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<PurchaseReadView> getAll() {
        return mapper.toPurchases((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseReadView>> getByClient(String clientId) {
        return purchaseCrudRepository.findByClientId(clientId)
                .map(it -> mapper.toPurchases(it));
    }

    @Override
    public PurchaseReadView save(PurchaseReadView purchase) {
        var changed = mapper.toPurchase(purchase);
        changed.getProducts().forEach(it -> it.setPurchase(changed));
        return mapper.toReadView(purchaseCrudRepository.save(changed));
    }
}
