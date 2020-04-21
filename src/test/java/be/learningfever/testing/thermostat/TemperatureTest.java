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
        //TODO finish the equals test
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
