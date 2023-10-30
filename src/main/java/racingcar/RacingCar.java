package racingcar;

public class RacingCar {
    private final RandomNumberGenerator randomNumberGenerator;
    private final String name;
    private int distance = 0;
    private String movingBar = "";

    public RacingCar(RandomNumberGenerator randomNumberGenerator, String name) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.name = name;
    }
}
