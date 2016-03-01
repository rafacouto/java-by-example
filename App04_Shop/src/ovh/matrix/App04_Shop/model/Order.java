package ovh.matrix.App04_Shop.model;

import java.util.*;

/**
 * Created by caligari on 2/29/16.
 */
public class Order implements Iterable<OrderItem> {

    protected Hashtable<Integer, OrderItem> items;



    Catalog catalog;

    public Catalog getCatalog() {
        return catalog;
    }



    public Order(Catalog catalog) {
        this.catalog = catalog;
    }



    public void setItem(int catalogItemId, int quantity) {

        if (quantity > 0) {

            if (!items.containsKey(catalogItemId)) {

                CatalogItem catalogItem = catalog.get(catalogItemId);
                if (catalogItem == null) return;

                OrderItem item = new OrderItem(catalogItem);
                items.put(catalogItem.getId(), item);
            }

            items.get(catalogItemId).setQuantity(quantity);
        }
    }



    public void removeItem(int catalogItemId) {

        if (items.containsKey(catalogItemId)) {

            items.remove(catalogItemId);
        }
    }



    public double getTotal() {

        double result = 0;

        for (OrderItem orderItem : items.values()) {

            result += orderItem.getSubtotal();
        }

        return result;
    }



    @Override
    public Iterator<OrderItem> iterator() {

        return items.values().iterator();
    }



    private static Order instance = null;

    public static Order getInstance() {

        if (instance == null) {

            instance = new Order(Catalog.getTestInstance());
        }

        return instance;

    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        for (OrderItem item : items.values()) {

            result.append(String.format("%d x %s x %.2f = %.2f\n",
                    item.getQuantity(),
                    item.getCatalogItem().getName(),
                    item.getCatalogItem().getPrice(),
                    item.getSubtotal()
                    ));
        }

        result.append(String.format("Total order: %.2f", getTotal()));

        return result.toString();
    }


    public List<OrderItem> getlist() {

        return Collections.list(items.elements());
    }


    public int size() {

        return items.size();
    }
}
