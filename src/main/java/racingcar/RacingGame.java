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
    private static long movement;
    private static long foundMax;
    public void startGame() {
        carName = new HashMap<>();
        inputUtil.inputCarName(carName);
        movement = inputUtil.inputMovement();

        System.out.println("\n실행 결과");

        for (int i = 0; i < movement; i++) {
            checker.checkMoveStop(carName);
        }

        foundMax = findMax();
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
        result.append("최종 우승자 :");

        for (String car : carName.keySet()) {
            if (carName.get(car) == foundMax) {
                result.append(" " + car + ",");
            }
        }
        System.out.print(result.deleteCharAt(result.length() - 1));
    }
}
