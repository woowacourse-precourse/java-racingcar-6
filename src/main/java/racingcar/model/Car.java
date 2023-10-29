package racingcar.model;

public class Car {

    private static final int DISTANCE_INITIALIZE = 0;
    private final String carName;
    private int distance;

    public Car(String carName){
        this.carName = carName;
        this.distance = DISTANCE_INITIALIZE;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public void updateDistance(){
        distance++;
    }
}
