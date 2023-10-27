package racingcar.business;

public class Car {

    private String name;
    private Integer distance;

    public Car(String name) {
        this.name = name;
    }

    private void forwardCar() {
        distance ++;
    }

}
