package be.learningfever.testing.thermostat;

import be.learningfever.testing.thermostat.exceptions.InvalidTemperatureException;

import java.util.Objects;

public class Temperature {
    public final static float ABSOLUTE_ZERO = -273.15f;
    private float value;

    public Temperature(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        if (value < ABSOLUTE_ZERO) {
            throw new InvalidTemperatureException("You reached the absolute zero for temperature");
        }
        this.value = value;
    }

    public boolean isBoiling(){
        return value >= 100;
    }

    public boolean isFreezing() {
        return value <= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature that = (Temperature) o;
        return Float.compare(that.getValue(), getValue()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
