package racingcar;

public class Car {
    private String name;
    private int gauge = 0;

    Car(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGauge(int gauge) {
        this.gauge = gauge;
    }

    String getName() {
        return name;
    }

    int getGauge() {
        return gauge;
    }
}
