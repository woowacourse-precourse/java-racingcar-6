package racingcar;

public class Car {
    private String name;
    private String distance;

    public Car(String name) {
        this.name = name;
        distance = "";
    }

    public String getName() {
        return name;
    }

    public void setDistance() {
        distance += "-";
    }

    public String getDistance() {
        return distance;
    }
}
