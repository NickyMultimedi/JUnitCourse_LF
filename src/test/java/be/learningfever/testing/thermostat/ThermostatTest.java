package be.learningfever.testing.thermostat;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ThermostatTest {
    private final static int INTERVAL = 10;
    private Thermostat therm;
    private HeatingMock heating;
    private SensorMock sensor;

    private class HeatingMock implements Heating {
        private boolean status;

        @Override
        public void setHeating(boolean status) {
            this.status = status;
        }

        public boolean isHeating() {
            return status;
        }
    }

    private class SensorMock implements Sensor {
        private float temp = 21f;
        private boolean called;

        @Override
        public Temperature getTemperature() {
            called = true;
            return new Temperature(temp);
        }

        public void setTemperature(float temp) {
            this.temp = temp;
        }

        boolean isCalled() {
            return called;
        }

        public void setCalled(boolean status) {
            called = status;
        }
    }

    @BeforeEach
    void init() {
        sensor = new SensorMock();
        heating = new HeatingMock();
        therm = new Thermostat(sensor, heating);
        therm.setInterval(INTERVAL);
        therm.setTargetTemperature(new Temperature(20f));
        sensor.setTemperature(20f);
        therm.start();
    }

    @Test
    void testThermostatStartsHeating() throws InterruptedException {
        sensor.setTemperature(19f);
        sensor.setCalled(false);
        heating.setHeating(false);
        Thread.sleep(INTERVAL * 3);
        assertTrue(therm.isHeating(), "Stupid thermostat");
        assertTrue(sensor.isCalled(), "Sensor wasnt called");
        assertTrue(heating.isHeating(), "Heating wasnt called");
    }

    @Test
    void timedTest() throws InterruptedException {
        Thread.sleep(INTERVAL * 3);
        assertTimeout(
                Duration.ofMillis(5),
                () -> therm.isHeating()
        );

        assertTimeoutPreemptively(
                Duration.ofMillis(5),
                () -> therm.isHeating()
        );
    }

    @RepeatedTest(value = 10)
    void repeatedTest(RepetitionInfo info) {
        System.out.println(info.getCurrentRepetition());
    }

    @AfterEach
    void destroy() {
        therm.stop();
    }

}
