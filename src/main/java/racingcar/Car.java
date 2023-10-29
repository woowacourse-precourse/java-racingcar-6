package racingcar;

import static racingcar.constant.Constant.COLON;

public abstract class Car {
    private String name;
    String distanceDriver;

    public Car(String name){
        this.name = name;
    }

    public abstract void moveCar();

    @Override
    public String toString() {
        return name + COLON +distanceDriver;
    }
}
