package racingcar;

import java.util.HashMap;
import java.util.Iterator;

public class RacingGame {
    static HashMap<String,Integer> carName;
    public void startGame() {
        carName = new HashMap<>();
        InputCarName inputCarName = new InputCarName();
        inputCarName.inputCarName(carName);

        Validation validation = new Validation();
        validation.inputCarNameLength(carName);

        InputMovement inputMovement = new InputMovement();
        int movement = inputMovement.inputMovement();

        CheckMoveStop checkMoveStop = new CheckMoveStop();
        System.out.println("실행 결과");

        for (int i = 0; i < movement; i++) {
            Iterator<String> iter = carName.keySet().iterator();
            checkMoveStop.checkMoveStop(carName, iter);
        }

        int foundMax = findMax();
        System.out.print("최종 우승자 :");
        printResult(foundMax);

    }

    private int findMax() {
        int instantMax = 0;
        for (String car : carName.keySet()) {
            int maxFind = carName.get(car);
            if (maxFind > Constant.max) {
                instantMax = maxFind;
            }
        }
        return instantMax;
    }

    private void printResult(int max) {
        StringBuilder result = new StringBuilder();
        for (String car : carName.keySet()) {
            if (carName.get(car) == max) {
                result.append(" " + car + ",");
            }
        }
        System.out.println(result.deleteCharAt(result.length() - 1));
    }
}
