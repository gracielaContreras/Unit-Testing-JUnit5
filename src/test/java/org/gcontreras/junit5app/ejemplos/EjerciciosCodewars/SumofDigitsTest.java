package org.gcontreras.junit5app.ejemplos.EjerciciosCodewars;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SumofDigitsTest {
    @Test
    public void Test1() {
        assertEquals( 7, SumofDigits.digital_root(16));
    }
    @Test
    public void Test2() {
        assertEquals(  6, SumofDigits.digital_root(456));
    }
}