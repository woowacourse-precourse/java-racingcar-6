package racingcar.model;

public class Player {
    private String carName;
    private int distance;

    public Player(String carName) {
        this.carName = carName;
        this.distance = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Player{" +
                "carName='" + carName + '\'' +
                ", distance=" + distance +
                '}';
    }
}
