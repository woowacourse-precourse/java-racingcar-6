package racingcar.car;

import racingcar.constant.OutputMessage;

public abstract class Car {
    private String name;
    String distanceDriver;

    public Car(String name){
        this.name = name;
        this.distanceDriver = "";
    }

    public abstract void moveCar(int number);

    public String getName(){
        return name;
    }

    public String getDistanceDriver(){
        return distanceDriver;
    }

    @Override
    public String toString() {
        return name + OutputMessage.COLON.getMessage() +distanceDriver;
    }
}
