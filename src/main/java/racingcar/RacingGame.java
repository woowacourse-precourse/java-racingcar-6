package racingcar;

import java.util.HashMap;
import java.util.Iterator;

public class RacingGame {
    static HashMap<String,Integer> carName;
    static InputCarName inputCarName = new InputCarName();
    static InputMovement inputMovement = new InputMovement();
    static CheckMoveStop checkMoveStop = new CheckMoveStop();
    static Validation validation = new Validation();
    public void startGame() {
        carName = new HashMap<>();
        inputCarName.inputCarName(carName);

        validation.inputCarNameLength(carName);

        int movement = inputMovement.inputMovement();

        System.out.println("실행 결과");

        for (int i = 0; i < movement; i++) {
            checkMoveStop.checkMoveStop(carName);
        }

        int foundMax = findMax();
        System.out.println(foundMax);
        System.out.print("최종 우승자 :");
        printResult(foundMax);

    }

    private int findMax() {
        int instantMax = Constant.max;
        for (String car : carName.keySet()) {
            int maxFind = carName.get(car);
            if (maxFind > instantMax) {
                instantMax = maxFind;
            }
        }
        return instantMax;
    }

    private void printResult(int foundMax) {
        StringBuilder result = new StringBuilder();
        for (String car : carName.keySet()) {
            if (carName.get(car) == foundMax) {
                result.append(" " + car + ",");
            }
        }
        System.out.println(result.deleteCharAt(result.length() - 1));
    }
}
