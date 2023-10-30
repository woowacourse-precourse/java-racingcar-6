package racingcar;

public class Car {
    private String name;
    private String forward;

    public Car(String name) {
        this.name = name;
        this.forward = "";
    }

    public String getName() {
        return this.name;
    }

    public String getForward() {
        return this.forward;
    }

    public void addForward() {
        this.forward += "-";
    }
}
