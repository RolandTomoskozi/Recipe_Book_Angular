package at.rt.sample.springboot.models;

/**
 * Basis Interface fuer alle JPA Entities. Entities muesen eine Methode zum Liefern der ID zur Verfuegung stellen.
 */
public interface IBaseEntity {

    /**
     * ID des Entity.
     *
     * @return ID
     */
    Long getId();
}
