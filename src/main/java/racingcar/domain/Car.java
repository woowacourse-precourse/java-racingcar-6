package racingcar.domain;

public class Car {
    private String name;
    private int movingDistance;

    public Car() {
    }

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

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.movingDistance++;
        }
    }

    public String getStatus() {
        return this.name +
                " : " +
                "-".repeat(this.movingDistance);
    }
}
