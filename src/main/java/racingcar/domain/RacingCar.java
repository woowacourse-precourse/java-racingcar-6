package racingcar.domain;

public class RacingCar {

    private String carName;
    private int forwardCount;

    public String getCarName() {
        return carName;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void increaseForwardCount() {
        this.forwardCount++;
    }
}
