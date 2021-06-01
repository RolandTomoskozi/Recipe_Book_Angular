package at.rt.sample.springboot.service.api;

import at.rt.sample.springboot.models.ShoppingList;

import java.util.List;
import java.util.Optional;

/**
 * Service-Interface fuer den Zugriff auf ShoppingList.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
public interface ShoppingListService {
    /**
     * Liefert die Liste aller ShoppingLists, sortiert nach der Bezeichnung.
     *
     * @return Liste von ShoppingLists
     */
    List<ShoppingList> listShoppingLists();

    /**
     * Sucht eine ShoppingList anhand der ID.
     *
     * @param id ID der ShoppingList
     * @return gefundene ShoppingList
     */
    Optional<ShoppingList> getShoppingListById(Long id);

    /**
     * Speichert eine ShoppingList.
     *
     * @param shoppingList Zu speichernde ShoppingList
     * @return gespeicherte ShoppingList
     */
    ShoppingList saveShoppingList(ShoppingList shoppingList);

    /**
     * Löscht eine ShoppingList anhand der ID.
     *
     * @param id ID der ShoppingList
     */
    void deleteShoppingList(Long id);
}
