package racingcar.model;

public class Car {
    private String carName;
    private int distance;

    public Car(String carName, int distance){
        this.carName = carName;
        this.distance = distance;
    }
    public String getCarName(){
        return this.carName;
    }

    public int getDistance(){
        return this.distance;
    }

    public void addDistance() {
        this.distance++;
    }
}
