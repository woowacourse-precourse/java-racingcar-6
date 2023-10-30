package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;

public class RacingGameView {

    public static void moveStatus(HashMap<String, String> carMoveStatus) {
        for (String userCarName : carMoveStatus.keySet()) {
            String userCarMoveResult = carMoveStatus.get(userCarName);
            System.out.println(userCarName + " : " + userCarMoveResult);
        }
        System.out.println();
    }

    public static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();
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
