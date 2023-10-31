package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    static final int GO = 4;

    public RacingGame() {
    }

    public void startRacingProcess() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsName = GameInput.inputCarsName();

        System.out.println("시도할 회수는 몇회인가요?");
        int maxRaceTime = GameInput.raceTime();
        CarList racingCarList = new CarList(carsName);

        System.out.println("실행 결과");
        for (int raceTime = 0; raceTime < maxRaceTime; raceTime++) {
            oneTimeRace(racingCarList);
            printRaceProgress(racingCarList);
        }
        printWinners(racingCarList);
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

    private void printWinners(CarList carList) {
        int[] maxCarPositionIndex = findMaxCarPositionIndex(carList);
        String maxCarPositionName;

        System.out.printf("최종 우승자 : ");
        for (int index = 0; index < maxCarPositionIndex.length; index++) {
            if (index >= 1) {
                System.out.printf(", ");
            }
            maxCarPositionName = carList.getName(maxCarPositionIndex[index]);
            System.out.printf(maxCarPositionName);
        }

    }

    private int[] findMaxCarPositionIndex(CarList carList) {
        int carPosition;
        int maxCarPosition = -1;
        List<Integer> maxCarPositionIndex = new ArrayList<>();

        for (int index = 0; index < carList.getSize(); index++) {
            carPosition = carList.getPosition(index);
            if (maxCarPosition == carPosition) {
                maxCarPositionIndex.add(index);
            } else if (maxCarPosition < carPosition) {
                maxCarPosition = carPosition;
                maxCarPositionIndex.clear();
                maxCarPositionIndex.add(index);
            }
        }
        return ListToIntArray(maxCarPositionIndex);
    }

    public int[] ListToIntArray(List<Integer> intList) {
        int[] intArray = new int[intList.size()];
        for (int index = 0; index < intArray.length; index++) {
            intArray[index] = intList.get(index);
        }
        return intArray;
    }
}
