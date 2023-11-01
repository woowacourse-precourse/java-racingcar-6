package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    static final int GO = 4;

    public RacingGame() {
    }

    public void startRacingProcess() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carsName = GameInput.CarsName();
        CarList racingCarList = new CarList(carsName);

        System.out.println("시도할 회수는 몇회인가요?");
        int maxRaceTime = GameInput.raceTime();

        System.out.println("실행 결과");
        for (int raceTime = 0; raceTime < maxRaceTime; raceTime++) {
            oneTimeRace(racingCarList);
            GameOutput.printRaceProgress(racingCarList);
        }
        GameOutput.printWinners(racingCarList);
        return;
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

}
