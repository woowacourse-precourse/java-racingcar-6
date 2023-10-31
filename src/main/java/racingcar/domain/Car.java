package racingcar.domain;

public class Car {
    private String name;
    private int totalDistance;

    public Car(String name) {
        this.name = name;
        totalDistance=0;
    }

    public String getName() {
        return name;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void move(int distance){
        totalDistance+=distance;
    }
}
