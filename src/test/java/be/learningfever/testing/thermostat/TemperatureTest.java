package be.learningfever.testing.thermostat;

import be.learningfever.testing.thermostat.exceptions.InvalidTemperatureException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {
    private final float TEMP = 21.02f;
    private final float ABSOLUTE_ZERO = -273.15f;
    private Temperature temp;

    @BeforeEach
    void initTestRun() {
        temp = new Temperature(TEMP);
    }

    @Test
    void testAbsoluteZero() {
        assertEquals(ABSOLUTE_ZERO, Temperature.ABSOLUTE_ZERO);
    }

    @Test
    void testConstructor() {
        assertEquals(TEMP, temp.getValue());
    }

    @Test
    void testConstructorThrowsInvalidTemperatureEException() {
        assertThrows(
                InvalidTemperatureException.class,
                () -> temp.setValue(ABSOLUTE_ZERO - 1)
        );
    }

    @Test
    void testValue() {
        float changedTemp = 22.34f;
        temp.setValue(changedTemp);
        assertEquals(changedTemp, temp.getValue());
    }

    @Test
    void testIsBoiling() {
        final float notBoiling = 99;
        final float startBoiling = 100;
        final float isBoiling = 101;

        temp.setValue(notBoiling);
        assertFalse(temp.isBoiling());

        temp.setValue(startBoiling);
        assertTrue(temp.isBoiling());

        temp.setValue(isBoiling);
        assertTrue(temp.isBoiling());

    }

    @Test
    void testIsFreezing() {
        final float notFreezing = 1;
        final float startFreezing = 0;
        final float isFreezing = -1;

        temp.setValue(notFreezing);
        assertFalse(temp.isFreezing());

        temp.setValue(startFreezing);
        assertTrue(temp.isFreezing());

        temp.setValue(isFreezing);
        assertTrue(temp.isFreezing());
    }

    @Test
    void valueCantGoBelowAbsoluteFreezing() {
        assertDoesNotThrow(
                () -> temp.setValue(ABSOLUTE_ZERO + 1)
        );

        assertDoesNotThrow(
                () -> temp.setValue(ABSOLUTE_ZERO),
                "absolute Zero reached, exception not thrown"
        );

        assertThrows(
                InvalidTemperatureException.class,
                () -> temp.setValue(ABSOLUTE_ZERO - 1),
                "Colder than Absolute Zero, exception not thrown"
        );
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
