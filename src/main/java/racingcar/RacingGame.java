package racingcar;

public class RacingGame {

    public RacingGame() {
    }

    public void startRacingProcess() {
        String carsName = GameInput.inputCarsName();
        CarList racingCarList = new CarList(carsName);
        int maxRaceTime = GameInput.raceTime();
    }

}
