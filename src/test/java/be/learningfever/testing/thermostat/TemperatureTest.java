package be.learningfever.testing.thermostat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {
    private final float TEMP = 21.02f;
    private Temperature temp;

    @BeforeEach
    void initTestRun() {
        temp = new Temperature(TEMP);
    }

    @Test
    void testConstructor() {
        assertEquals(TEMP, temp.getValue());
    }

    @Test
    void testValue() {
        float changedTemp = 22.34f;
        temp.setValue(changedTemp);
        assertEquals(changedTemp, temp.getValue());
    }

    @Test
    void testEquals() {
        reflexiveTest();
        symmetricTest();
        transitiveTest();
        consistentTest();
        nullTest();
    }

    private void reflexiveTest() {
        assertEquals(temp, temp, "Equals is not Reflexive");
    }

    private void symmetricTest() {
        Temperature temp2 = new Temperature(temp.getValue());
        assertEquals(temp.equals(temp2), temp2.equals(temp), "Equals is not Symmetric");
    }

    private void transitiveTest() {
        Temperature temp2 = new Temperature(temp.getValue());
        Temperature temp3 = new Temperature(temp.getValue());
        boolean first = temp.equals(temp2);
        boolean second = temp2.equals(temp3);
        boolean third = temp.equals(temp3);
        assertTrue(first && second && third, "Equals is not Transitive");
    }

    private void consistentTest() {
        Temperature temp2 = new Temperature(temp.getValue());
        int size = 10;
        boolean[] checks = new boolean[size];
        boolean[] controle = new boolean[size];

        for (int i = 0; i < 10; i++) {
            checks[i] = temp.equals(temp2);
            controle[i] = true;
        }

        assertArrayEquals(controle, checks, "Equals is not Consistent");
    }

    private void nullTest() {
        assertNotEquals(null, temp, "Equals is not null proof");
    }

    @Test
    void testHashCode() {
        //TODO finish the hasCode test
    }

    @AfterEach
    void resetTestRun() {
        temp = null;
    }

}
