package racingcar.utils;

public enum Message {
    EXECUTION_RESULT_MESSAGE("실행 결과"),
    FINAL_WINNER_MESSAGE("최종 우승자 : "),
    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_INPUT_MESSAGE("시도할 횟수는 몇회인가요?"),
    ERROR_EMPTY_CAR_NAME_MESSAGE("공백을 입력할 수는 없습니다."),
    ERROR_INVALID_CAR_NAME_LENGTH_MESSAGE("자동차 이름은 5자 이하로만 가능합니다."),
    ERROR_DUPLICATE_CAR_NAME_MESSAGE("중복된 자동차 이름이 있습니다."),
    ERROR_NON_NUMBERIC_MOVE_COUNT_MESSAGE("숫자만 입력 가능합니다."),
    ERROR_RACE_MINIMUM_CAR_MESSAGE("경주를 시작하기 위해서는 최소 2대 이상의 자동차가 필요합니다."),
    ERROR_INVALID_MOVE_COUNT_EXCEPTION("이동 횟수는 1 이상이어야 경주를 시작할 수 있습니다.");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
