package be.learningfever.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {

    @Test
    public void testSayHello() {
        HelloWorld hello = new HelloWorld();
        String testValue = hello.sayHello();
        String expectedValue = "Hello World!";
        assertEquals(expectedValue, testValue);
    }
}
