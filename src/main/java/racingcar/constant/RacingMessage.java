package racingcar.constant;

import static racingcar.constant.RacingSign.*;

public class RacingMessage {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 %s(%s) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String TRY_RESULT = "실행 결과";
    private static final String RACING_PROGRESS = "%s : %s";
    private static final String RACING_WINNER = "최종 우승자 : %s";

    public static String getInputCarNameMessage() {
        return String.format(INPUT_CAR_NAME, CAR_NAME_SEPARATOR_TEXT, CAR_NAME_SEPARATOR);
    }

    public static String getInputTryCountMessage() {
        return INPUT_TRY_COUNT;
    }

    public static String getTryResultMessage() {
        return TRY_RESULT;
    }

    public static String getRacingProgressMessage(String name, String progressBar) {
        return String.format(RACING_PROGRESS, name, progressBar);
    }

    public static String getWinnerMessage(String winners) {
        return String.format(RACING_WINNER, winners);
    }
}
