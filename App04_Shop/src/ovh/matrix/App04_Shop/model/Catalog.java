package ovh.matrix.App04_Shop.model;

import java.util.*;

/**
 * Created by caligari on 2/29/16.
 */
public class Catalog extends Dictionary<Integer, CatalogItem> {

    protected Hashtable<Integer, CatalogItem> items;


    public Catalog() {

        this.items = new Hashtable<>();
    }


    public Catalog(Iterable<CatalogItem> items) {

        this();

        for (CatalogItem item : items) {

            this.put(item.getId(), item);
        }
    }



    private static final CatalogItem[] testCollection = {
            new CatalogItem(1, "Coin Battery Holder CR2025 and CR2032", 10d),
            new CatalogItem(2, "2N3904 NPN General Purpose Transistor", 11d),
            new CatalogItem(3, "NE555 IC 555 Timer DIP-8", 12d),
            new CatalogItem(4, "1590B Style Aluminum Diecast Enclosure", 13d),
            new CatalogItem(5, "Super Hard On DIY PCB Guitar Effect", 14d),
            new CatalogItem(6, "ZIF Socket 40 Pin 0.6\"", 15d),
            new CatalogItem(7, "Stackable Header 6 Pins 2.54mm", 16d),
            new CatalogItem(8, "Davies 1510 Clone Black Knob", 17d),
            new CatalogItem(9, "1N34A 1N34 Germanium Diode DO-7", 18d),
            new CatalogItem(10, "LED 5mm White Water Clear Ultra Bright", 19d)
    };



    public static Catalog getTestInstance() {
        return new Catalog(Arrays.asList(testCollection));
    }



    @Override
    public Enumeration<CatalogItem> elements() {
        return items.elements();
    }

    @Override
    public CatalogItem get(Object o) {
        return items.get(o);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public Enumeration<Integer> keys() {
        return items.keys();
    }

    @Override
    public CatalogItem put(Integer id, CatalogItem catalogItem) {
        return items.put(id, catalogItem);
    }

    @Override
    public CatalogItem remove(Object o) {
        return items.remove(o);
    }

    @Override
    public int size() {
        return items.size();
    }

    public List<CatalogItem> getList() {

        return Collections.list(items.elements());
    }
}
