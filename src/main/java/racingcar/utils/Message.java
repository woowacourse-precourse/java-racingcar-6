package racingcar.utils;

public enum Message {
    EXECUTION_RESULT_MESSAGE("실행 결과"),
    FINAL_WINNER_MESSAGE("최종 우승자 : "),
    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_INPUT_MESSAGE("시도할 횟수는 몇회인가요?"),
    ERROR_EMPTY_CAR_NAME_MESSAGE("자동차 이름을 공백으로 할 수 없습니다."),
    ERROR_INVALID_CAR_NAME_LENGTH_MESSAGE("자동차 이름은 5자 이하로만 가능합니다"),
    ERROR_DUPLICATE_CAR_NAME_MESSAGE("중복된 자동차 이름이 있습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
