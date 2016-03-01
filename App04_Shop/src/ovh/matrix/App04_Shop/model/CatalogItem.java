package ovh.matrix.App04_Shop.model;

/**
 * Created by caligari on 2/29/16.
 */
public class CatalogItem {

    int id;

    public int getId() {
        return id;
    }



    String name;

    public String getName() {
        return name;
    }



    double price;

    public double getPrice() {
        return price;
    }



    public CatalogItem(int id, String name, double price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }



    @Override
    public String toString() {

        return String.format("[id=%d, name=\"%s\"]", id, name);
    }
}
