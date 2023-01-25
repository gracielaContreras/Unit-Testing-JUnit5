package org.gcontreras.junit5app.ejemplos.EjerciciosCodewars;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WhoLikesItTest {
    @Test
    public void staticTests() {
        assertEquals("no one likes this", WhoLikesIt.whoLikesIt());
        assertEquals("Peter likes this", WhoLikesIt.whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", WhoLikesIt.whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", WhoLikesIt.whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", WhoLikesIt.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}