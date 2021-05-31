package at.rt.sample.springboot.repo;

import at.rt.sample.springboot.models.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
}
