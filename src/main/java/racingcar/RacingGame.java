package racingcar;

public class RacingGame {

    private final RacingCars racingCars;

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void play() {
        racingCars.turnOn();
    }
}
