package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    static final int GO = 4;

    public RacingGame() {
    }

    public void startRacingProcess() {
        String carsName = GameInput.inputCarsName();
        int maxRaceTime = GameInput.raceTime();
        CarList racingCarList = new CarList(carsName);

        System.out.println("실행 결과");
        for (int raceTime = 0; raceTime < maxRaceTime; raceTime++) {
            oneTimeRace(racingCarList);
            printRaceProgress(racingCarList);
        }
    }

    private void oneTimeRace(CarList racingCarList) {
        setRandomNumber_ZeroToNine(racingCarList);
        goOrStop(racingCarList);
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

    private void goOrStop(CarList racingCarList) {
        int motionState;
        for (int index = 0; index < racingCarList.getSize(); index++) {
            motionState = racingCarList.getMotionState(index);
            if (motionState >= GO) {
                racingCarList.plusOnePosition(index); // motionState is Go
            }
        }
        return;
    }

    private void printRaceProgress(CarList racingCarList) {
        for (int carIndex = 0; carIndex < racingCarList.getSize(); carIndex++) {
            System.out.print(racingCarList.getName(carIndex) + " : ");
            for (int carPosition = 0; carPosition < racingCarList.getPosition(carIndex); carPosition++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
        return;
    }

}
