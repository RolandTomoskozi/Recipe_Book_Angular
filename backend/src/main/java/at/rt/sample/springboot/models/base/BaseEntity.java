package at.rt.sample.springboot.models.base;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Basisklasse fuer alle Entities. Implementiert ID/HashCode anhand der ID und toString.
 *
 * @param <ID> The Id Type of the Entity
 */
@MappedSuperclass
@EntityListeners()
public abstract class BaseEntity<ID extends Serializable> implements Serializable, IBaseEntity<ID> {

    @Override
    public String toString() {
        return getClass().getName() + " [id=" + getId() + "]";
    }

    @Override
    public int hashCode() {
        ID id = getId();

        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        if (getId() == null) {
            return other.getId() == null;
        } else if (!getId().equals(other.getId())) {
            return false;
        }
        return true;
    }

}
