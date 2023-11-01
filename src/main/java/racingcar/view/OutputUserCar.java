package racingcar.view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import racingcar.model.Car;

public class OutputUserCar {
    private static final String CYCLE_RESULT_COMMENT = "실행결과";
    private static final String GAME_RESULT_COMMENT = "최종 우승자 : ";

    public static void printResultComment() {
        System.out.println(CYCLE_RESULT_COMMENT);
    }

    public static void racingCurrent(Map<String, Integer> currentSituation) {
        Iterator<String> iterator = currentSituation.keySet().iterator();
        currentSituation.size();
        while (iterator.hasNext()) {
            String keyValue = iterator.next();
            String scoreString = personalResultValue(currentSituation.get(keyValue));
            printPersonalResultComment(keyValue, scoreString);
        }
        System.out.println();
    }

    public static void printPersonalResultComment(String carName, String scoreValue) {
        System.out.println(carName + " : " + scoreValue);
    }

    public static String personalResultValue(int scoreInt) {
        String scoreString = "";
        while (scoreInt-- > 0) {
            scoreString += "-";
        }
        return scoreString;
    }

    public static void printGameResultComment() {
        System.out.print(GAME_RESULT_COMMENT);
    }

    public static String winnerString(List<String> userList) {
        return String.join(",", userList);
    }

    public static void printWinnerResultComment() {
        System.out.println(winnerString(Car.getResultWinner()));
    }

    public static void printFinalResultComment() {
        printGameResultComment();
        printWinnerResultComment();
    }
}
