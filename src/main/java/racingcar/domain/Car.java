package racingcar.domain;

public class Car {
    private final String carName;
    private int position = 0;

    public Car(String carName){
        this.carName = carName;
    }

    public String getCarName(){
        return carName;
    }

    public int getPosition(){
        return position;
    }
}
