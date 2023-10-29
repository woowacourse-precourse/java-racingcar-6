package racingcar.domain.caractions;

public class Car {
    private int distance;

    public Car(){
        distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void advanceCar(){
        distance++;
    }

}
