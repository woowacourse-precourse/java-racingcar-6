package racingcar.model;

public class Car {
    private String carName;
    private int distance;

    public Car(String carName){
        this.carName = carName;
        this.distance = 0;
    }

    public void addDistance() {
        this.distance++;
    }
}
