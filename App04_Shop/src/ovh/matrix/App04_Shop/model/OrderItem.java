package ovh.matrix.App04_Shop.model;

/**
 * Created by caligari on 2/29/16.
 */
public class OrderItem {

    CatalogItem catalogItem;

    public CatalogItem getCatalogItem() {
        return catalogItem;
    }



    int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public double getSubtotal() {

        return catalogItem.getPrice() * quantity;
    }



    public OrderItem(CatalogItem catalogItem) {

        this.catalogItem = catalogItem;
        this.quantity = 0;
    }
}
