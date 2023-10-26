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

    public void setName(String name) {
        this.name = name;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }
}
