package ovh.matrix.test.sintaxis;

public class Main {

    public static void main(String[] args) {

        // salida de texto por consola
        System.out.println("A consola non é nada consoladora.");

        // declaración e asignación de variables int (enteiras, 2 bytes)
        int myIntValue = 5 / 2;
        System.out.println("myIntValue = " + myIntValue);

        // declaración e asignación de variables float (decimal, 4 bytes)
        float myFloatValue = 5f / 41f;
        System.out.println("myFloatValue = " + myFloatValue);

        // declaración e asignación de variables double (decimal, 8 bytes)
        double myDoubleValue = 5d / 41d;
        System.out.println("myDoubleValue = " + myDoubleValue);

        // asignación e operacións
        double poundInKg = 0.45359237d;
        double pounds = 200d;
        double kilos = pounds * poundInKg;
        System.out.println(pounds + " libras son " + kilos + " Kg");

        // String
        String first = "Java";
        String copy = " (\u00A9 2016) ";
        String second = "Daba";
        System.out.println(first + copy + second);
        String pi = "3.149265";
        System.out.println(Double.parseDouble(pi) * 2);

        // operadores numéricos
        int a = 1 + 2;
        int b = a - 1;
        int c = b * 2;
        int d = c / 3;
        d++;

        // booleanos
        boolean isEven = (d % 2 == 0);
        if (isEven) {
            System.out.println("d é par");
        }
        else {
            System.out.println("d é impar");
        }


    }
}
