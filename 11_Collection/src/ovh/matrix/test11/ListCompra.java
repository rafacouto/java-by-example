package ovh.matrix.test11;

import java.util.ArrayList;

/**
 * Created by caligari on 2/24/16.
 */
public class ListCompra {

    private ArrayList<String> lista = new ArrayList<String>();

    public void anhadirProducto(String producto) {
        lista.add(producto);
    }

    public void modificarProducto(int pos, String producto) {
        lista.set(pos, producto);
    }

    public void quitarProducto(int pos) {
        if (pos > 0 && pos < lista.size()) {
            lista.remove(pos);
        }
    }

    public String buscarProducto(String producto) {
        int posicion = lista.indexOf(producto);
        if (posicion >= 0) {
            return lista.get(posicion);
        }
        return null;
    }

    public void ImprimirList() {
        System.out.println("Hay " + lista.size() + " elementos en la cesta...");
    }
}
