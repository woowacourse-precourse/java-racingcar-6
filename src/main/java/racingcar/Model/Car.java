package racingcar.Model;

public class Car {
    private String name;
    private int step;

    public Car(String name) {
        if (!isNameValidate(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.step = 0;
    }

    private Boolean isNameValidate(String name) {
        return name.length() <= 5;
    }

    public void goStraight(int stepSize) {
        step += 1;
    }

    public int getCurrentLocation() {
        return step;
    }

    public String getCarName() {
        return name;
    }
}
