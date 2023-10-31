package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    public RacingGame() {
    }

    public void startRacingProcess() {
        String carsName = GameInput.inputCarsName();
        int maxRaceTime = GameInput.raceTime();
        CarList racingCarList = new CarList(carsName);

        for (int raceTime = 0; raceTime < maxRaceTime; raceTime++) {
            oneTimeRace(racingCarList);
        }
    }

    private void oneTimeRace(CarList racingCarList) {
        setRandomNumber_ZeroToNine(racingCarList);
        return;
    }

    private void setRandomNumber_ZeroToNine(CarList racingCarList) {
        Car car = null;
        int randomNumber = -1;

        for (int index = 0; index < racingCarList.getSize(); index++) {
            randomNumber = Randoms.pickNumberInRange(0, 9);
            racingCarList.setMotionState(index, randomNumber);
        }
        return;
    }

}
