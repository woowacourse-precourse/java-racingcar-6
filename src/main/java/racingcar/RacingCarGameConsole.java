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

    public void race() {
        for (int i = 0; i < timesToTry; i++) {
            tryMoving();
        }
    }

    private void tryMoving() {
        System.out.println("\n실행 결과");
        carIndex = 0;
        while (carIndex < numberOfCars) {
            updateCarMovement(randomNumber());
            System.out.println(carMovement(car.movedLately(carIndex)));
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

    public String carMovement(int movedLately) {
        return car.name(carIndex) + " : " + "-".repeat(movedLately);
    }
}
