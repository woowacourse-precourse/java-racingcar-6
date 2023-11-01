package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MOVING_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String GAME_ROUND_RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printInfomation(String infomation) {
        System.out.println(infomation);
    }

    public static void printInputCarNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public static void printInputMovingTryCountMessage() {
        System.out.println(INPUT_MOVING_TRY_COUNT_MESSAGE);
    }

    public static void printGameRoundResultMessage() {
        System.out.println(GAME_ROUND_RESULT_MESSAGE);
    }

    public static void printGameRoundResultMessage(List<String> winnerList) {
        System.out.println(WINNER_MESSAGE + String.join(", ", winnerList));
    }
}
