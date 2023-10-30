package racingcar;

public class Car {
    String name;
    String distance;

    Car(String name) {
        distance = "";
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
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
