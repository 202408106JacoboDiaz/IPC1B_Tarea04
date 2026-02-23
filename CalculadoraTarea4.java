
import java.util.Scanner;

public class CalculadoraTarea4 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean appActiva = true;
        while(appActiva){
            //Menú de inicio
            System.out.println("===== CALCULADORA =====");
            System.out.println("1 <- SUMA");
            System.out.println("2 <- RESTA");
            System.out.println("3 <- MULTIPLICACIÓN");
            System.out.println("4 <- DIVISIÓN");
            System.out.println("5 <- POTENCIA");
            System.out.println("6 <- RAÍZ");
            System.out.println("7 <- SALIR");
            System.out.println("SELECCIONE UNA OPCIÓN: ");
            String opcionMenu = scanner.nextLine().trim();

            //Redirección al mét. de la operación seleccionada
            switch (opcionMenu){
                case "1":
                    mostrarsuma(scanner);
                    break;
                case "2":
                    mostrarresta(scanner);
                    break;
                case "3":
                    mostrarmultiplicacion(scanner);
                    break;
                case "4":
                    mostrardivision(scanner);
                    break;
                case "5":
                    mostrarpotencia(scanner);
                    break;
                case "6":
                    mostrarraiz(scanner);
                    break;
                case "7":
                    System.out.println("SALIENDO...");
                    appActiva = false;
                    break;
                default:
                    System.out.println("OPCIÓN NO VÁLIDA, INTÉNTELO DE NUEVO.");
                    break;
            }
        }
        scanner.close();
    }

    //Mét. para pedir y verificar un número válido
    static double leerNum (Scanner num, String men){
        double numero = 0; boolean validacion = false;
        while (!validacion){
            System.out.print(men);
            try{
                numero = Double.parseDouble(num.nextLine().trim());
                validacion = true;
            }catch (NumberFormatException e){
                System.out.println("ENTRADA NO VÁLIDA, INGRESE OTRO NÚMERO.");
            }
        }
        return numero;
    }

    //Mét. para sumar 2 números
    static void mostrarsuma(Scanner scanner){
        double num01 = leerNum(scanner, "INGRESE SU PRIMER NÚMERO: ");
        double num02 = leerNum(scanner, "INGRESE SU SEGUNDO NÚMERO: ");
        double resultado = num01 + num02;
        System.out.println( num01 + " + " + num02 + " = " + resultado);
    }
    //Mét. para restar 2 números
    static void mostrarresta(Scanner scanner){
        double num01 = leerNum(scanner, "INGRESE SU NÚMERO: ");
        double num02 = leerNum(scanner, "INGRESE EL NÚMERO QUE LE RESTARÁ: ");
        double resultado = num01 - num02;
        System.out.println( num01 + " - " + num02 + " = " + resultado);
    }
    //Mét. para multiplicar 2 números
    static void mostrarmultiplicacion(Scanner scanner){
        double num01 = leerNum(scanner, "INGRESE SU PRIMER NÚMERO: ");
        double num02 = leerNum(scanner, "INGRESE SU SEGUNDO NÚMERO: ");
        double resultado = num01 * num02;
        System.out.println( num01 + " * " + num02 + " = " + resultado);
    }
    //Mét. para dividir 2 números
    static void mostrardivision(Scanner scanner){
        double num01 = leerNum(scanner, "INGRESE SU DIVIDENDO: ");
        double num02 = 0;
        //Verificar que el denominador no sea cero
        boolean valdenominador = false;
        while (!valdenominador){
            num02 = leerNum(scanner, "INGRESE SU DIVISOR: ");
            if (num02 == 0){
                System.out.println("SYNTAX ERROR, PRUEBE OTRO DIVISOR.");
            }else{
                valdenominador = true;
            }
        }
        double resultado = num01 / num02;
        System.out.println( num01 + " / " + num02 + " = " + resultado);
    }
    //Mét. para elevar un número a otro número
    static void mostrarpotencia(Scanner scanner){
        double num01 = leerNum(scanner, "INGRESE SU NÚMERO: ");
        double num02 = leerNum(scanner, "INGRESE SU EXPONENTE: ");
        double resultado = Math.pow(num01, num02);
        System.out.println( num01 + " ^ " + num02 + " = " + resultado);
    }
    //Mét. para sacar la raíz n-nésima de un número
    static void mostrarraiz(Scanner scanner){
        double num01 = 0;
        double num02 = 0;
        double num01_ = 0;
        double resultado = 0;
        boolean validacion = false;
        while (!validacion){
            num01 = leerNum(scanner, "INGRESE SU NÚMERO: ");
            num02 = leerNum(scanner, "INGRESE EL ÍNDICE DE SU RAÍZ: ");
            num01_ = Math.abs(num01);
            //Error si se saca la raíz par de un número negativo
            if(num01 < 0 && num02 % 2 == 0){
                    System.out.println("SYNTAX ERROR, PRUEBE OTROS NÚMEROS.");
            }else{
                validacion = true;
            }
        }
        //Raíz impar de un número negativo
        if(num01 < 0 && num02 % 2 != 0){
            resultado = -Math.pow(num01_, 1.00/num02);
        //Raíz de un número positivo
        }else if(num01 >= 0){
            resultado = Math.pow(num01, 1.00/num02);
        }
        System.out.println("Raíz " + num02 + " de " + num01 + " = " + resultado);
    }
}
