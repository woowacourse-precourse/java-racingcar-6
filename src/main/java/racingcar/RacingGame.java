package racingcar;

public class RacingGame {

    public RacingGame() {
    }

    public void startRacingProcess() {
        String carsName = GameInput.inputCarsName();
        CarList racingCarList = new CarList(carsName);
        int maxRaceTime = GameInput.raceTime();
        for (int raceTime = 0; raceTime < maxRaceTime; raceTime++) {
            oneTimeRace(racingCarList);
        }
    }

    private void oneTimeRace(CarList racingCarList) {
        
    }

}
