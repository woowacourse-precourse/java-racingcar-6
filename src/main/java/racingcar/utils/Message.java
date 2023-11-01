package racingcar.utils;

public enum Message {
    START_GAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPT_NUM_MESSAGE("시도할 회수는 몇회인가요?"),
    RESULT_MESSAGE("실행결과"),
    PROGRESSBAR_CHAR("-"),
    WINNER_PRINT_MESSAGE("최종 우승자 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
