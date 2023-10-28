package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGameConsole {
    private Car car;
    private final List<String> winnerCarNames = new ArrayList<>();
    private static final int MOVE_JUDGE_INTEGER = 4;
    private int carIndex = 0;
    private int numberOfCars = 0;
    private int timesToTry = 0;
    private int mostMovedAmount = 0;

    public void run() {
        set();
        race();
        printResult();
    }

    private void set() {
        car = new Car(InputView.carName());
        numberOfCars = car.numberOf();
        timesToTry = InputView.timesToTry();
    }

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
