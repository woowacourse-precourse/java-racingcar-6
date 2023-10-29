package racingcar;

import java.util.HashMap;
import java.util.Iterator;

public class RacingGame {
    static HashMap<String,Integer> carName;
    public void startGame() {
        carName = new HashMap<>();
        InputCarName inputCarName = new InputCarName();
        inputCarName.inputCarName(carName);
        System.out.println(carName);

        InputMovement inputMovement = new InputMovement();
        int movement = inputMovement.inputMovement();
        System.out.println(movement);

        CheckMoveStop checkMoveStop = new CheckMoveStop();
        System.out.println("실행 결과");

        for (int i = 0; i < movement; i++) {
            Iterator<String> iter = carName.keySet().iterator();
            checkMoveStop.checkMoveStop(carName, iter);
        }
        System.out.println(carName);

        int max = maxFind();
        System.out.println(max);
        System.out.print("최종 우승자 :");
        printResult(max);

    }

    private int maxFind() {
        int max = -1;
        for (String car : carName.keySet()) {
            int maxFind = carName.get(car);
            if (maxFind > max) {
                max = maxFind;
            }
        }
        return max;
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
