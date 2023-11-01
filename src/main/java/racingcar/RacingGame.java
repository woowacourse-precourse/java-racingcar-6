package racingcar;

public class RacingGame {

    private RacingCars racingCars;

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void play() {
        racingCars.turnOn();
    }
}
