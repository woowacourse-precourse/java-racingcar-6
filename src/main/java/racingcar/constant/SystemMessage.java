package racingcar.constant;

public enum SystemMessage {
    GAME_START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRIAL_MESSAGE("시도할 회수는 몇회인가요?"),
    RESULT_MESSAGE("실행 결과"),
    WINNER_MESSAGE("최종 우승자 : ");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}
