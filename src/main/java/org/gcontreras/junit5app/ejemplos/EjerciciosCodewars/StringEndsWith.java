package org.gcontreras.junit5app.ejemplos.EjerciciosCodewars;

import java.util.stream.Stream;

/**
 * Complete the solution so that it returns true if the first argument(string)
 * passed in ends with the 2nd argument (also a string).
 *
 * Examples:
 *
 * solution('abc', 'bc') // returns true
 * solution('abc', 'd') // returns false
 * solution('samurai', 'ai') // returns true
 */

public class StringEndsWith {
    public static void main(String[] args) {
    }
    public static boolean solution(String str, String ending) {

//        if ( str.contains(ending) ){
//
//            for ( int i = str.length() -1; i >= 0; i-- ){
//                char[] caracterStr =  str.toCharArray();
//                char[] caracterEnding =  ending.toCharArray();
//
//                for ( int j = ending.length() -1; j >= 0; j-- ) {
//
//                    if ( str.equalsIgnoreCase( ending ))
//                        return true;
//
//                    if ( caracterStr[i] == caracterEnding[j] ) {
//
//                        if ( j == 0 || caracterStr[i -1] == caracterEnding[j -1] )
//                            return true;
//                    } else
//                        return false;
//                }
//                if ( ending.length() == 0)
//                    return true;
//            }
//        }
//        return false;

        //Otra forma de hacer el ejercicio
//        return str.length() >= ending.length() ?
//                str.substring(str.length()-ending.length()).equals(ending) : false;

        return str.length() >= ending.length() ?
                str.endsWith(ending) : false;
    }
}
