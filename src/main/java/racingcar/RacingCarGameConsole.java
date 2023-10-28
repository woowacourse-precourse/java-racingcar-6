package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarGameConsole {
    private static final int MOVE_JUDGE_INTEGER = 4;
    private Car car;
    private int carIndex = 0;
    private int numberOfCars = 0;
    private int timesToTry = 0;

    private void race() {
        while (timesToTry > 0) {
            tryMoving();
            timesToTry--;
        }
    }

    private void tryMoving() {
        System.out.println("\n실행 결과");
        carIndex = 0;
        while (carIndex < numberOfCars) {
            updateCarMovement();
            printCarMovement();
            carIndex++;
        }
    }

    private void updateCarMovement() {
        if (moveAllowed()) {
            car.move(carIndex);
        }
    }

    private boolean moveAllowed() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= MOVE_JUDGE_INTEGER;
    }

    private void printCarMovement() {
        System.out.print(car.name(carIndex) + " : ");
        for (int i = 0; i < car.movedLately(carIndex); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
