package at.rt.sample.springboot.models.base;

import java.io.Serializable;

/**
 * Basis Interface fuer alle JPA Entities. Entities muesen eine Methode zum Liefern der ID zur Verfuegung stellen.
 *
 * @param <ID> The Id Type of the entity
 */
public interface IBaseEntity<ID extends Serializable> {

    /**
     * ID des Entity.
     *
     * @return ID
     */
    ID getId();
}
