package ovh.matrix.test11;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ListCompra groceryList = new ListCompra();

    public static void main(String[] args) {
        boolean quit = false;
        int opcion = 0;
        imprimirInstructiones();
        while (!quit) {
            System.out.println("Seleccione opciÃ³n: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0:
                    imprimirInstructiones();
                    break;
                case 1:
                    groceryList.imprimirLista();
                    break;
                case 2:
                    anyadirProducto();
                    break;
                case 3:
                    modificarProducto();
                    break;
                case 4:
                    quitarProducto();
                    break;
                case 5:
                    buscarProducto();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void imprimirInstructiones() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - Ver opciones.");
        System.out.println("\t 1 - Ver lista compra.");
        System.out.println("\t 2 - Anyadir producto.");
        System.out.println("\t 3 - Modificar producto");
        System.out.println("\t 4 - Quitar producto");
        System.out.println("\t 5 - Buscar priducto.");
        System.out.println("\t 6 - Salir.");
    }

    public static void anyadirProducto() {
        System.out.print("Nombre producto ");
        groceryList.anhadirProducto(scanner.nextLine());
    }

    public static void modificarProducto() {
        System.out.print("Enrar numero producto: ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Producto modificado: ");
        String newItem = scanner.nextLine();
        groceryList.modificarProducto(itemNo - 1, newItem);
    }

    public static void quitarProducto() {
        System.out.print("Numero producto: ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
        groceryList.quitarProducto(itemNo - 1);

    }

    public static void buscarProducto() {
        System.out.print("Produto: ");
        String searchItem = scanner.nextLine();
        if (groceryList.buscarProducto(searchItem) != null) {
            System.out.println("Hallado " + searchItem + " en lista");
        } else {
            System.out.println(searchItem + " no estÃ¡  en lista");
        }
    }


}
