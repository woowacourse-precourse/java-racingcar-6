package racingcar.view;

import java.util.List;
import racingcar.constant.GameMessage;
import racingcar.controller.Validator;

public class OutputView {
    public static void askCarName() {
        System.out.println(GameMessage.INPUT_CAR_MESSAGE);
    }

    public static void askCount() {
        System.out.println(GameMessage.INPUT_COUNT_MESSAGE);
    }

    public static void startRace() {
        System.out.println();
        System.out.println(GameMessage.RESULT_MESSAGE);
    }

    public static void printResult(List<String> userName, List<Integer> distance) {
        for (int i = 0; i < userName.size(); i++) {
            System.out.print(userName.get(i));
            System.out.print(" : ");
            for (int j = 0; j < distance.get(i); j++) {
                System.out.print("_");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static String plusWinner(String result, String playerName) {
        if (result.isEmpty()) {
            result = playerName;
            return result;
        }
        result = result + ", " + playerName;
        return result;
    }

    public static void printWinner(List<String> playerName, List<Integer> playerDistance, Integer winnerDistance) {
        System.out.print(GameMessage.WINNER_MESSAGE);
        String result = "";
        for (int i = 0; i < playerName.size(); i++) {
            if (Validator.isWinner(winnerDistance, playerDistance.get(i))) {
                result = plusWinner(result, playerName.get(i));
            }
        }
        System.out.println(result);
    }

}
