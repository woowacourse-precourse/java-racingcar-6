package racingcar;

public class Car {
    private String name;
    private int movingDistance;

    public Car(String name, int movingDistance) {
        this.name = name;
        this.movingDistance = movingDistance;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getMovingDistance() {
        return movingDistance;
    }

    public void setMovingDistance(int movingDistance) {
        this.movingDistance = movingDistance;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(movingDistance);
    }
}
