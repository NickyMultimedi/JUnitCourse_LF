package be.learningfever.testing.thermostat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThermostatTest {
    private final static int INTERVAL = 10;
    private Thermostat therm;
    private HeatingStub heating;
    private SensorStub sensor;

    private class HeatingStub implements Heating {

        @Override
        public void setHeating(boolean status) {

        }
    }

    private class SensorStub implements Sensor {
        private float temp = 21f;

        @Override
        public Temperature getTemperature() {
            return new Temperature(temp);
        }

        public void setTemperature(float temp) {
            this.temp = temp;
        }
    }

    @BeforeEach
    void init() {
        sensor = new SensorStub();
        heating = new HeatingStub();
        therm = new Thermostat(sensor, heating);
        therm.setInterval(INTERVAL);
        therm.setTargetTemperature(new Temperature(20f));
        sensor.setTemperature(20f);
        therm.start();
    }

    @Test
    void testThermostatStartsHeating() throws InterruptedException {
        sensor.setTemperature(19f);
        Thread.sleep(INTERVAL * 3);
        assertTrue(therm.isHeating());
    }

    @AfterEach
    void destroy() {
        therm.stop();
    }

}
