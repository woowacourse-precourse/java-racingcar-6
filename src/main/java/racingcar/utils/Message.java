package racingcar.utils;

public enum Message {
    EXECUTION_RESULT_MESSAGE("실행 결과"),
    FINAL_WINNER_MESSAGE("최종 우승자 : "),
    INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_COUNT_MESSAGE("시도할 횟수는 몇회인가요?"),
    INPUT_EMPTY_CAR_NAME_ERROR_MESSAGE("공백을 입력할 수는 없습니다."),
    INPUT_CAR_NAME_ERROR_MESSAGE("자동차 이름은 5자 이하로만 가능합니다."),
    DUPLICATE_CAR_NAME_ERROR_MESSAGE("중복된 자동차 이름이 있습니다."),
    INPUT_NUMBER_ERROR_MESSAGE("숫자만 입력 가능합니다.");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
