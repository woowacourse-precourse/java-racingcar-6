package racingcar.message;

public enum AlarmMessage {
    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
    MOVE_COUNT_INPUT_MESSAGE("시도할 회수는 몇회인가요?"),
    BEFORE_GAME_PROGRESS_MESSAGE("실행 결과"),
    RESULT_HEADER_MESSAGE("최종 우승자 : ");

    private final String message;

    AlarmMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
