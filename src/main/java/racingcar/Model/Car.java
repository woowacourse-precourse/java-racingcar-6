package racingcar.Model;

public class Car {
    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void incrementDistance() {
        this.distance++;
    }


}
