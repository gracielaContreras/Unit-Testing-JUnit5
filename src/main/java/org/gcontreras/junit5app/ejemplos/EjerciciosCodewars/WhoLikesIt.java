package org.gcontreras.junit5app.ejemplos.EjerciciosCodewars;

/**
 * Who likes it?
 * You probably know the "like" system from Facebook and other pages. People can "like" blog posts,
 * pictures or other items. We want to create the text that should be displayed next to such an item.
 *
 * Implement the function which takes an array containing the names of people that like an item.
 * It must return the display text as shown in the examples:
 *
 * []                                -->  "no one likes this"
 * ["Peter"]                         -->  "Peter likes this"
 * ["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
 * ["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
 * ["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"
 *
 * Note: For 4 or more names, the number in "and 2 others" simply increases.
 */
public class WhoLikesIt {
    public static void main(String[] args) {
        System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max", "Jacob"));
    }

    public static String whoLikesIt(String... names) {

        //Do your magic here
        String[] list = names;

        for( int i = 0; i < list.length; i++) {
            if( list.length == 1 && ! (list.equals(""))){
                return list[i] +" likes this";
            }
            if( list.length ==2 ){
                return list[i]  +" and " + list[i + 1] +" like this";
            }
            if( list.length ==3 ){
                return list[i]  +", " + list[i + 1] + " and " + list[i + 2] +" like this";
            }
            if( list.length >=4 ){
                return list[i]  +", " + list[i + 1] + " and "+ (list.length - 2) + " others like this";
            }
        }
        return "no one likes this";

        //Otra forma de resolver el ejercicio
//        switch (names.length) {
//            case 0: return "no one likes this";
//            case 1: return String.format("%s likes this", names[0]);
//            case 2: return String.format("%s and %s like this", names[0], names[1]);
//            case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
//            default: return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
//        }

        //Otra forma de resolver el ejercicio
/*        List<String> list = Arrays.asList(names);
        for( int i = 0; i < list.size(); i++) {
            if( list.size() == 1 && ! (list.contains(""))){
                return list.get(i) +" likes this";
            }
            if( list.size() ==2 ){
                return list.get(i) +" and " + list.get( i + 1) +" like this";
            }
            if( list.size() ==3 ){
                return list.get(i) +", " + list.get(i + 1) + " and " + list.get(i + 2) +" like this";
            }
            if( list.size() >=4 ){
                return list.get(i) +", " + list.get(i + 1) + " and "+ (list.size() - 2) + " others like this";
            }
        }

                return "no one likes this";*/



    }
}
