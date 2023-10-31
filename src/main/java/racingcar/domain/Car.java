package racingcar.domain;

public class Car {
    private final String name;
    private String state = "";

    Car(String name) {
        this.name = name;
    }

    public void accelerate() {
        state += "-";
    }

    public boolean canAccelerate(int power) {
        if (power >= 4) {
            return true;
        }
        return false;
    }

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }
}
