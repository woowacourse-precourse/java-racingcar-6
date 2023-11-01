package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    private static final String CAR_APPEND_STRING_COLON = " : ";
    private static final String CAR_APPEND_STRING_DASH = "-";
    private static final String FINAL_WINNER_RESULT_STRING = "최종 우승자 :";
    private static final String FINAL_WINNER_STRING_JOIN_NAME_COMMA = ", ";

    private OutputView() {
    }

    public static void printRacingStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAskCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printCarsMove(Map<String, Integer> currentPosition) {
        for (Entry<String, Integer> carsInformation : currentPosition.entrySet()) {
            StringBuilder carString = new StringBuilder();
            carString.append(carsInformation.getKey());
            carString.append(CAR_APPEND_STRING_COLON);
            for (int i = 0; i < carsInformation.getValue(); i++) {
                carString.append(CAR_APPEND_STRING_DASH);
            }
            System.out.println(carString);
        }
        System.out.println();
    }

    public static void printFindWinner(List<String> winners) {
        System.out.println(winnerPrintFormat(winners));
    }

    public static String winnerPrintFormat(List<String> winners) {
        return FINAL_WINNER_RESULT_STRING + " " + String.join(FINAL_WINNER_STRING_JOIN_NAME_COMMA, winners);
    }

}
