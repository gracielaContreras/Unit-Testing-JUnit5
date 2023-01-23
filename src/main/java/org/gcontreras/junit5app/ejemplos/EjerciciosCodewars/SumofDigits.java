package org.gcontreras.junit5app.ejemplos.EjerciciosCodewars;

import java.util.stream.Stream;

/**
 * Digital root is the recursive sum of all the digits in a number.
 *
 * Given n, take the sum of the digits of n. If that value has more than one digit,
 * continue reducing in this way until a single-digit number is produced.
 * The input will be a non-negative integer.
 *
 * Examples
 *     16  -->  1 + 6 = 7
 *    942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
 * 132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
 * 493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
 */
public class SumofDigits {
    public static void main(String[] args) {
        digital_root(493193);
//        System.out.println(digital_root(132189));
//        digital_root(132189);
//        digital_root(942);
//        digital_root(16);
    }
    public static int digital_root(int n) {
        while ( n > 0 ) {
            char[] caracter = String.valueOf(n).toCharArray();

            if (!(caracter.length <= 1)) {
                int sum = 0;

                for (int i = 0; i < caracter.length; i++) {
                    int numero = Integer.parseInt(String.valueOf(caracter[i]));
                    sum += numero;
                    System.out.print(caracter[i] + " + ");
                    n = sum;
                }

                System.out.print(" = " + n);
                System.out.print(" --> ");

            } else {
                break;
            }
        }
        return n;

        //Otra forma de resolver el ejercicio
//        return (n != 0 && n%9 == 0) ? 9 : n % 9;

        //Otra forma de resolver el ejercicio
//        Ejemplo con Stream
//        if (n < 10) {
//            return Stream.of(String.valueOf(n).split(""))
//                    .mapToInt(Integer::parseInt)
//                    .sum();
//        } else {
//            return digital_root(Stream.of(String.valueOf(n).split(""))
//                    .mapToInt(Integer::parseInt)
//                    .sum());
//        }

    }
}
