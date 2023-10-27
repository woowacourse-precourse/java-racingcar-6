package racingcar.domain;

public class Car {

    private final String name;

    private int totalMovedDistance;

    public Car(String name) {
        this.name = name;
        this.totalMovedDistance = 0;
    }

    public void move(){
        totalMovedDistance+=1;
    }

    public String getName() {
        return name;
    }

    public int getTotalMovedDistance() {
        return totalMovedDistance;
    }
}
