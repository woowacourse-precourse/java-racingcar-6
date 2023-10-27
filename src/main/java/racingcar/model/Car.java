package racingcar.model;

public class Car {

    String carName = "";
    int carFoward = 0;

    public Car() {
    }


    public Car setCar(String carName) {
        this.carName = carName;
        return this;
    }
}
