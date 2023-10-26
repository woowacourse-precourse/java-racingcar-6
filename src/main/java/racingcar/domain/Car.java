package racingcar.domain;

public class Car {

    public String name;
    public String forward;

    public Car(String name) {
        this.name = name;
        this.forward = "";
    }

    public String getName() {
        return name;
    }

    public String getForward() {
        return forward;
    }
}
