package co.cgiar.view.manager.ggceview.persistence.mapper;

import co.cgiar.view.manager.ggceview.domain.CategoryReadView;
import co.cgiar.view.manager.ggceview.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "id", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "state", target = "active")
    })
    CategoryReadView toReadView(Category category);

    @InheritInverseConfiguration
    Category toCategory(CategoryReadView category);
}
