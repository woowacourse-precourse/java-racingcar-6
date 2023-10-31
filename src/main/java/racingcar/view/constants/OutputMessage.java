package racingcar.view.constants;

public enum OutputMessage {
    ASK_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_GAME_ROUNDS("시도할 횟수는 몇회인가요?"),
    GAME_RESULT("실행 결과"),
    DISPLAY_USER_SCORE_SIGN(":"),
    SCORE_SIGN("-"),
    FINAL_WINNER("최종 우승자 :");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
