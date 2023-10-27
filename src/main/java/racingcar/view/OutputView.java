package racingcar.view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String INPUT_RACING_CAR_MESSAGE= "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACING_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String RACING_RESULT_FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public static void printCarNameInputMessage() {
        System.out.println(INPUT_RACING_CAR_MESSAGE);
    }

    public static void printRacingCountInputMessage() {
        System.out.println(INPUT_RACING_COUNT_MESSAGE);
    }

    public static void printRacingResultMessage() {
        System.out.println();
        System.out.println(RACING_RESULT_MESSAGE);
    }

    public static void printRacingRoundResult(String carName, int position) {
        System.out.println(carName + " : " + makeCarPosition(position));
    }

    public static String makeCarPosition(int position) {
        StringBuilder carPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            carPosition.append("-");
        }
        return carPosition.toString();
    }

    public static void printRacingWinner(List<String> carNames) {
        StringJoiner joiner = new StringJoiner(", ");
        for (String carName : carNames) {
            joiner.add(carName);
        }
        System.out.println(RACING_RESULT_FINAL_WINNER_MESSAGE + joiner.toString());
    }
}
