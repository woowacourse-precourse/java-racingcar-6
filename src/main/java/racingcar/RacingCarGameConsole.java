package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGameConsole {
    private final Car car;
    private final List<String> winnerCarNames = new ArrayList<>();
    private static final int MOVE_JUDGE_INTEGER = 4;
    private final int numberOfCars;
    private final int timesToTry;
    private int carIndex = 0;
    private int mostMovedAmount = 0;

    public RacingCarGameConsole(Car car, int timesToTry) {
        this.car = car;
        numberOfCars = car.numberOf();
        isCorrectTimesToTry(timesToTry);
        this.timesToTry = timesToTry;
    }

    private static void isCorrectTimesToTry(int timesToTry) {
        if (timesToTry <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_RANGE_MISMATCH);
        }
    }

    public void run() {
        race();
        printResult();
    }

    private void race() {
        for (int i = 0; i < timesToTry; i++) {
            tryMoving();
        }
    }

    private void tryMoving() {
        System.out.println("\n실행 결과");
        carIndex = 0;
        while (carIndex < numberOfCars) {
            updateCarMovement(randomNumber());
            printCarMovement();
            carIndex++;
        }
    }

    public void updateCarMovement(int randomNumber) {
        if (moveAllowed(randomNumber)) {
            car.move(carIndex);
        }
    }

    private boolean moveAllowed(int randomNumber) {
        return randomNumber >= MOVE_JUDGE_INTEGER;
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void printCarMovement() {
        System.out.print(car.name(carIndex) + " : ");
        for (int i = 0; i < car.movedLately(carIndex); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void printResult() {
        setWinnerCarNames();
        System.out.print("\n최종 우승자 : " + String.join(", ", winnerCarNames));
    }

    private void setWinnerCarNames() {
        mostMovedAmount = car.mostMovedAmount();
        carIndex = 0;
        while (carIndex < numberOfCars) {
            addToListIfWinner(carIndex);
            carIndex++;
        }
    }

    private void addToListIfWinner(int carIndex) {
        if (car.movedLately(carIndex) == mostMovedAmount) {
            winnerCarNames.add(car.name(carIndex));
        }
    }
}
