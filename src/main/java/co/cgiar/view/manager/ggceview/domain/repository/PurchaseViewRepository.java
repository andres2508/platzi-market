package co.cgiar.view.manager.ggceview.domain.repository;

import co.cgiar.view.manager.ggceview.domain.PurchaseReadView;

import java.util.List;
import java.util.Optional;

public interface PurchaseViewRepository {
    List<PurchaseReadView> getAll();

    Optional<List<PurchaseReadView>> getByClient(String clientId);

    PurchaseReadView save(PurchaseReadView purchase);
}
