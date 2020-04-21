package be.learningfever.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class HelloWorldTest {
    private HelloWorld hello;

    public HelloWorldTest() {
        System.out.println("Constructor");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each");
        hello = new HelloWorld();
    }

    @Test
    @DisplayName("Saying Hello to the World")
    void testSayHello() {
        HelloWorld hello = new HelloWorld();
        String testValue = hello.sayHello();
        String expectedValue = "Hello World!";
        assertEquals(expectedValue, testValue, "Oepsie");
        assertNull(null);
    }

    @Test
    @DisplayName("Saying Hello to Nick")
    void testSayHelloTo() {
        HelloWorld hello = new HelloWorld();
        String testValue = hello.sayHelloTo("Nick");
        String expectedValue = "Hello Nick";
        assertEquals(expectedValue, testValue);
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After Each");
        hello = null;
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After All");
    }
}
