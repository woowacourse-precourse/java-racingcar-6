package racingcar.model;

public class Car {
    private String name;
    private String step;

    public String getName() {
        return name;
    }

    public String getStep() {
        return step;
    }

    public Car(String name) {
        this.name = name;
        this.step = "";
    }

    public void goForward() {
        this.step += "-";
    }
}
