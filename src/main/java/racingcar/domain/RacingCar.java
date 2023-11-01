package racingcar.domain;

public class RacingCar {

    private String carName;
    private String forwardProgress;
    private int forwardCount;

    public RacingCar(String carName, String forwardProgress, int forwardCount) {
        this.carName = carName;
        this.forwardProgress = forwardProgress;
        this.forwardCount = forwardCount;
    }

    public String getCarName() {
        return carName;
    }

    public String getForwardProgress() {
        return forwardProgress;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void increaseForwardProgress() {
        this.forwardCount++;
        this.forwardProgress += "-";
    }
}
