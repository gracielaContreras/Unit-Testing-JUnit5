package org.gcontreras.junit5app.ejemplos.EjerciciosCodewars;

/**
 * String Repeat
 * Write a function that accepts an integer n and a string s as parameters,
 * and returns a string of s repeated exactly n times.
 *
 * Examples (input -> output)
 * 6, "I"     -> "IIIIII"
 * 5, "Hello" -> "HelloHelloHelloHelloHello"
 */

public class StringRepeat {
    public static String repeatStr(final int repeat, final String string) {
        return string.repeat(repeat);
    }
}
