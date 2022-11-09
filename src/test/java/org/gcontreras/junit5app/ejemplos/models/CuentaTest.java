package org.gcontreras.junit5app.ejemplos.models;

import org.gcontreras.junit5app.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class CuentaTest {

    Cuenta cuenta;

    @BeforeEach
    void initMetodoTest() {
     this.cuenta = new Cuenta("Eduardo", new BigDecimal("1000.12345"));
        System.out.println("inicializado metodo");
    }

    @AfterEach
    void tearDown() {
        System.out.println("finalizando el metodo de prueba");
    }

    @Test
    @DisplayName("probando el nombre de la cuenta corriente!")
    void testNombreCuenta() {                       //BigDecimal se colocó los numeros como String por un tema precision
        String esperado = "Eduardo";
        String real = cuenta.getPersona();
        assertNotNull(real, () -> "La cuenta no puede ser nula"); //agregando información de porque fallo
        assertEquals(real, esperado, () -> "El nombre de la cuenta no es el que se esperaba");
        assertTrue(real.equals(esperado), () -> "nombre cuenta esperada debe ser igual a la real");
    }

    @Test
    @DisplayName("probando el saldo de la cuenta corriente, que no sea null, mayor que cero, valor esperado")
    void testSaldoCuenta() {
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    @DisplayName("testeando referencias que sena iguales con el metodo equals.")
    void testReferenciaCuenta() {
        Cuenta cuenta1 = new Cuenta("Tom", new BigDecimal("1000.12345"));
        Cuenta cuenta2 = new Cuenta("Tom", new BigDecimal("1000.12345"));
        assertEquals(cuenta2, cuenta1);
    }

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta1 = new Cuenta("Tom", new BigDecimal("1000.12345"));
        cuenta1.debito(new BigDecimal("100"));

        assertNotNull(cuenta1.getSaldo());
        assertEquals(900, cuenta1.getSaldo().intValue());
        assertEquals("900.12345", cuenta1.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        cuenta.credito(new BigDecimal("100"));

        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testDineroInsuficiente() {
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal("1500"));
        });
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }

    @Test
    void testTransferirCuenta() {
        Cuenta cuenta1 = new Cuenta("Tom", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Eduardo", new BigDecimal("1500.12345"));

        Banco banco = new Banco();
        banco.setNombre("Banco Estado");
        banco.trasferirCuenta(cuenta2, cuenta1, new BigDecimal(500));

        assertEquals("1000.12345", cuenta2.getSaldo().toPlainString());
        assertEquals("3000", cuenta1.getSaldo().toPlainString());
    }

    @Test
    @DisplayName("probando relaciones entre las cuentas y el banco assertAll")
    void testRelacionBancoCuentas() {
        Cuenta cuenta1 = new Cuenta("Tom", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Eduardo", new BigDecimal("1500.12345"));

        Banco banco = new Banco();
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);
        banco.setNombre("Banco Estado");

        assertEquals(2, banco.getCuentas().size());
        assertEquals("Banco Estado", cuenta1.getBanco().getNombre());

        //1° forma
        assertEquals("Eduardo", banco.getCuentas().stream()
                .filter(c -> c.getPersona().equals("Eduardo"))
                .findFirst()
                .get().getPersona());
        //2° forma
        assertTrue(banco.getCuentas().stream()
                .filter(c -> c.getPersona().equals("Eduardo"))
                .findFirst()
                .isPresent());
        //3° forma
        assertTrue(banco.getCuentas().stream()
                .anyMatch(c -> c.getPersona().equals("Eduardo")));
    }

    @Test
    @Disabled //Desactivar test
    void testRelacionBancoCuentasConAssertAll() {
        fail(); //Fuerza un error
        Cuenta cuenta1 = new Cuenta("Tom", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Eduardo", new BigDecimal("1500.12345"));

        Banco banco = new Banco();
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);
        banco.setNombre("Banco Estado");

//        assertAll agrupa varios tipos de assert
        assertAll(() -> assertEquals(2, banco.getCuentas().size()),
                () -> assertEquals(2, banco.getCuentas().size()),
                () -> assertEquals("Banco Estado", cuenta1.getBanco().getNombre()),
                () -> assertEquals("Eduardo", banco.getCuentas().stream()
                        .filter(c -> c.getPersona().equals("Eduardo"))
                        .findFirst()
                        .get().getPersona()),
                () -> assertTrue(banco.getCuentas().stream()
                        .filter(c -> c.getPersona().equals("Eduardo"))
                        .findFirst()
                        .isPresent()),
                () -> assertTrue(banco.getCuentas().stream()
                        .anyMatch(c -> c.getPersona().equals("Eduardo"))));

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testSoloWindows() {
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testSoloLinuxMac() {
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void testNoWindows() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testSoloJava8() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_18)
    void testSoloJava18() {
    }
    @Test
    @DisabledOnJre(JRE.JAVA_18)
    void testNoJava18() {
    }

    @Test
    void imprimirSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> System.out.println(k + ":"+v));
    }

    @Test
    @EnabledIfSystemProperty(named = "user.name", matches = "aguzm")
    void testUsername() {
    }

    @Test
    @EnabledIfSystemProperty(named = "ENV", matches = "dev")
    void testDev() {
    }
    @Nested //anidar pruebas unitarias
    @DisplayName("Pruebas Parameterized Test")
    class PruebasParameterizedTest {
        //Escribiendo pruebas parametrizadas con @ParameterizedTest
        //Diferentes formas de poder repetir nuestras pruebas de forma parametrizadas
        // utilizando datos de entrada distintos en cada ejecución
        @ParameterizedTest(name = "numero {index} ejecutando con valor {0}")
        @ValueSource(strings = { "100", "200", "300", "400", "500", "700", "900.12345"})
        void testDebitoCuentaValueSource(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }
        @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
        @CsvSource({"1,100", "2,200", "3,300", "4,400", "5,500", "6,700", "7,900.12345"})
        void testDebitoCuentaCsvSource(String index, String monto) {
            System.out.println(index + " -> " + monto);
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
        @CsvFileSource(resources = "/data.csv")
        void testDebitoCuentaCsvFileSource(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
        @MethodSource("montoList")
        void testDebitoCuentaMethodSource(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
        @CsvSource({"110,100, pepe, pepe", "210,200, edu,edu", "310,300, tom,tom",
                "410,400, lois, lois", "510,500, isa, isa", "710,700, lex,lex", "1100.12345,1000.12345, cata,cata"})
        void testDebitoCuentaCsvSource2(String saldo, String monto, String esperado, String actual) {
            System.out.println(saldo + " -> " + monto);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            cuenta.setPersona(actual);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
        @CsvFileSource(resources = "/data2.csv")
        void testDebitoCuentaCsvFileSource2(String saldo, String monto, String esperado, String actual) {
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            cuenta.setPersona(actual);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }
        static List<String> montoList() {
            return Arrays.asList("100", "200", "300", "400", "500", "600", "700", "900.12345");
        }

        @Nested
        class EjemploTimeoutTest{

            @Test
            @Timeout(2)
            void testPruebaTimeout() throws InterruptedException {
                TimeUnit.SECONDS.sleep(1);
            }
            @Test
            @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
            void testPruebaTimeout2() throws InterruptedException {
                TimeUnit.MILLISECONDS.sleep(100);
            }

            @Test
            void TestPruebaTimeoutAssertions() {
                assertTimeout(Duration.ofSeconds(5), () ->{
                    TimeUnit.MILLISECONDS.sleep(400);
                });
            }
        }
    }


}