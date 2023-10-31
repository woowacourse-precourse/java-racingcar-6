package racingcar.model;

public class Car {

    private String name;
    private int distance;

    private Car(String name) {
        this.name = name;
        this.distance =0;
    }

    public static Car createCar(String name){
        return new Car(name);
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
