package be.learningfever.testing.thermostat;

public class Thermostat {
    private final static int DEFAULT_INTERVAL = 100;

    private Heating heating;
    private Sensor sensor;
    private Thread thread;
    private Temperature targetTemperature;
    private int interval = DEFAULT_INTERVAL;
    private boolean status;

    public Thermostat(Sensor sensor, Heating heating) {
        setSensor(sensor);
        setHeating(heating);
    }

    public void start() {
        this.thread = new Thread(this::run);
        thread.setDaemon(true);
        thread.start();
    }

    private void run() {
        while (thread == Thread.currentThread()) {
            evaluate();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    private void evaluate() {
        Temperature currentTemperature = sensor.getTemperature();
        status = currentTemperature.getValue() < targetTemperature.getValue();
        heating.setHeating(status);
    }

    public void stop() {
        this.thread = null;
    }

    public Heating getHeating() {
        return heating;
    }

    public void setHeating(Heating heating) {
        this.heating = heating;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Temperature getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Temperature targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isHeating() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
