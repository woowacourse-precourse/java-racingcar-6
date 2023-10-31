package racingcar;

public class Car {
    private String name;
    private int movingDistance;

    Car(String name) {
        this.name = name;
        this.movingDistance = 0;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setmovingDistance(int movingDistance) {
        this.movingDistance = movingDistance;
    }
    public int getmovingDistance() {
        return movingDistance;
    }
    public void moveForward() {
        movingDistance += 1;
    }
}
