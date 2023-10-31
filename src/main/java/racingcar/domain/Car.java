package racingcar.domain;

import java.util.List;

public class Car {
    private String name;
    private StringBuffer forwardDistance;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StringBuffer getForwardDistance() {
        return forwardDistance;
    }

    public void setForwardDistance(StringBuffer forwardDistance) {
        this.forwardDistance = forwardDistance;
    }

    public void carStatus(Car car) {
        System.out.println(car.name + " : " + car.forwardDistance);
    }
}
