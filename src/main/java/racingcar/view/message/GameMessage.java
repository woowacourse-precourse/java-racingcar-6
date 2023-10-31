package racingcar.view.message;

public final class GameMessage {
    private GameMessage() {

    }

    public static final String GAME_PROGRESS_RESULT_FORMAT = "%s : %s";
    public static final String CAR_NAME_INPUT_QUESTION_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TOTAL_ROUND_INPUT_QUESTION_MESSAGE = "시도할 횟수는 몇회인가요?";
    public static final String GAME_RESULT_PREFIX_MESSAGE = "실행 결과";
    public static final String WINNER_NAME_MESSAGE_FORMAT = "최종 우승자 : %s";
}
