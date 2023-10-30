package racingcar.domain;

public class racingCar {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int FORWARD_POINT = 4;
    private static String racingCarName;
    private static int forwardCount;
    private static int randomNumber;

    public racingCar(String racingCarName) {
        this.racingCarName = racingCarName;
        this.forwardCount = 0;
    }
}
