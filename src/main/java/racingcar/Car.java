package racingcar;

public class Car {
    private String name;
    private String distance;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name + " : ";
    }

    public void setDistance(String distance) {
        this.distance = distance + "-";
    }

    public String getDistance() {
        return distance;
    }
}
