package at.rt.sample.springboot.dto.mapper;

import at.rt.sample.springboot.models.base.BaseEntity;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;

import javax.persistence.EntityManager;

public class JpaVersionMapper {

    /**
     * Diese Klasse wird verwendet, um Entitäten aus dem {@link EntityManager} zu lösen.
     * {@link javax.persistence.OptimisticLockException} Es ist typisch, wenn wir versuchen, eine Entität zu ändern,
     * die in der Zwischenzeit bereits geändert wurde (z.B. zwei Benutzer bearbeiten dieselbe Entität, aber eine
     * speichert vor dem anderen).
     */
    @BeforeMapping
    public <Model, Entity extends BaseEntity<?>> void beforeMapping(Model model, @MappingTarget Entity entity) {
        if (entity.getId() != null) { // only execute the code if the given ID is not null
            EntityManager entityManager = MappingUtil.applicationContext().getBean(EntityManager.class);
            entityManager.detach(entity);
        }
    }
}
