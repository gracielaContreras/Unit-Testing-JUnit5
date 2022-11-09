# Unit-Testing-JUnit5

# ¿Qué es JUnit?

JUnit test es una librería de java para escribir y ejecutar repetibles pruebas unitarias.

# ¿Qué es  JUnit 5?

JUnit es un framework para escribir pruebas unitarias de nuestro código y ejecutarlas en la JM. Utiliza programación funcional y lambda e incluye varios estilos diferentes de pruebas, configuraciones anotaciones, ciclos de vida, etc.

Las pruebas unitarias continuas en el tiempo esto nos asegura que ante cualquier cambio en nuestra aplicación siga funcionando correctamente por ejemplo si otra persona, un compañero más adelante realiza un cambio en nuestro código agrega una nueva funcionalidad y si falla la Pruebas unitarias significa que ese cambio que se realizo esta rompiendo algo en la funcionalidad del código que ya existia de nuestro código y este test ha detectado el cambio. Hay esta la importancia de las Pruebas unitarias podemos detectar este error y corregimos. 

# Algunas de las anotaciones más comunes

@Test

@DisplayName

@Nested

@Tag

@ExtendWith

@BeforeEach

@AfterEach

@BeforeAll

@AfterAll

@Disable

La anotación @ParameterizedTest

Nos permite poder repetir nuestras pruebas de forma parametrizadas utilizando datos de entrada que son distintos en cada ejecución.
