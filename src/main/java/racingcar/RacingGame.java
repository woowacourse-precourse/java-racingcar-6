package racingcar;

import racingcar.constant.ConstantNumber;
import racingcar.domain.CheckMoveStop;
import racingcar.input.InputUtil;
import racingcar.validation.InputValidation;

import java.util.HashMap;

public class RacingGame {
    private static HashMap<String,Integer> carName;
    private static final InputUtil inputUtil = new InputUtil();
    private static final CheckMoveStop checker = new CheckMoveStop();
    private static final InputValidation validator = new InputValidation();
    private static long movement;
    private static long foundMax;
    public void startGame() {
        carName = new HashMap<>();

        inputUtil.inputCarName(carName);
        validator.inputCarNameLength(carName);
        validator.inputCarNameBlank(carName);

        movement = inputUtil.inputMovement();
        validator.inputMovementLimit(movement);

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < movement; i++) {
            checker.checkMoveStop(carName);
        }

        foundMax = findMax();

        System.out.print("최종 우승자 :");

        printResult(foundMax);
    }

    private long findMax() {
        long instantMax = ConstantNumber.max;

        for (String car : carName.keySet()) {
            int findMax = carName.get(car);

            if (findMax > instantMax) {
                instantMax = findMax;
            }
        }
        return instantMax;
    }

    private void printResult(long foundMax) {
        StringBuilder result = new StringBuilder();

        for (String car : carName.keySet()) {
            if (carName.get(car) == foundMax) {
                result.append(" " + car + ",");
            }
        }
        System.out.print(result.deleteCharAt(result.length() - 1));
    }
}
