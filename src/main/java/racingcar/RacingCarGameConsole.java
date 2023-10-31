package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGameConsole {
    private static final String INT_TYPE = "^[0-9]*$";
    private static final int TIMES_TO_TRY_MINIMUM = 0;
    private static final int MOVE_JUDGE_INTEGER = 4;
    private final Car car;
    private final List<String> winnerNames = new ArrayList<>();
    private final int numberOfCars;
    private final int timesToTry;
    private int carIndex = 0;
    private int mostMovedAmount = 0;

    public RacingCarGameConsole(Car car, String timesToTry) {
        this.car = car;
        numberOfCars = car.numberOf();
        isCorrectTimesToTry(timesToTry);
        this.timesToTry = Integer.parseInt(timesToTry);
    }

    private static void isCorrectTimesToTry(String timesToTryString) {
        checkTimesToTryUngiven(timesToTryString);
        checkTimesToTryIsPositiveInteger(timesToTryString);
    }

    private static void checkTimesToTryUngiven(String timesToTryString) {
        if (timesToTryString.isEmpty()) {
            throw new IllegalArgumentException(ExceptionCase.INPUT_UNGIVEN.message());
        }
    }

    private static void checkTimesToTryIsPositiveInteger(String timesToTryString) {
        if (!timesToTryString.matches(INT_TYPE) || Integer.parseInt(timesToTryString) <= 0) {
            throw new IllegalArgumentException(ExceptionCase.TIMES_TO_TRY_TYPE_MISMATCH.message());
        }
    }

    public void play() {
        race();
        printWinnerNames();
    }

    public void race() {
        for (int moveTry = 0; moveTry < timesToTry; moveTry++) {
            tryMoving();
        }
    }

    private void tryMoving() {
        OutputView.printExecutionResultInKorean();
        carIndex = 0;
        while (carIndex < numberOfCars) {
            updateCarMovement(oneDigitRandomNumber());
            OutputView.printCarMovement(car.name(carIndex), car.movedLately(carIndex));
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

    private int oneDigitRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void printWinnerNames() {
        setWinnerNamesList();
        OutputView.printResult(winnerNames);
    }

    public void setWinnerNamesList() {
        mostMovedAmount = car.mostMovedAmount();
        for (carIndex = 0; carIndex < numberOfCars; carIndex++) {
            addNamesToListIfWinner();
        }
    }

    private void addNamesToListIfWinner() {
        if (car.movedLately(carIndex) == mostMovedAmount) {
            winnerNames.add(car.name(carIndex));
        }
    }
}
