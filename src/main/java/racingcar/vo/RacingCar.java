package racingcar.vo;

public class RacingCar {
    private String racingCarName;
    private int forwardDistance = 0;

    public RacingCar(String racingCarName) {
        this.racingCarName = racingCarName;
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    public int getDistance() {
        return forwardDistance;
    }

    public void setForwardDistance(int distance) {
        forwardDistance = distance;
    }
}
