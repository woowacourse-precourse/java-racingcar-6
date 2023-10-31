package racingcar.domain;

public class Car {
    private String name;
    private String movingDistance;

    public Car() {
    }

    public Car(String name, String movingDistance) {
        this.name = name;
        this.movingDistance = movingDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovingDistance() {
        return movingDistance;
    }

    public void setMovingDistance(String movingDistance) {
        this.movingDistance = movingDistance;
    }

    public void move(int randomNumber) {
    }

    public String getStatus() {
        return "";
    }
}
