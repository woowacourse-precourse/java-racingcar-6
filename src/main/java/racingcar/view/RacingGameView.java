package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;
import racingcar.Constant;
import racingcar.controller.ExceptionController;

public class RacingGameView {

    public static void moveStatus(HashMap<String, String> carMoveStatus) {
        for (String userCarName : carMoveStatus.keySet()) {
            String userCarMoveResult = carMoveStatus.get(userCarName);
            System.out.println(userCarName + " : " + userCarMoveResult);
        }
        System.out.println();
    }

    public static void inputCarNameMessage() {
        System.out.println(Constant.INPUT_CAR_NAME);
    }

    public static String inputCarName() {
        inputCarNameMessage();
        String inputCarName = readLine();

        ExceptionController.stringBlankException(inputCarName);

        return inputCarName;
    }

    public static int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static void winner(List<String> carMoveStatus) {
        String winner = String.join(", ", carMoveStatus);
        System.out.println("최종 우승자 : " + winner);
    }
}
