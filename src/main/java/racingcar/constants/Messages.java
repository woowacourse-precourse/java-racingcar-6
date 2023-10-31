package racingcar.constants;

public enum Messages {
    // INPUT
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요. (이름은 " + GameInfo.SEPARATOR_NAME + "(" + GameInfo.SEPARATOR
        + ") 기준으로 구분)"),
    INPUT_ROUND_NUM("시도할 회수는 몇 회 인가요?"),

    // OUTPUT
    OUTPUT_RESULT_HEADER("실행 결과"),
    OUTPUT_WINNER_PREFIX("최종 우승자 : "),

    // ERROR
    ERROR_CAR_NAMES_LENGTH("자동차 이름은 " + GameInfo.MIN_CAR_NAME_LENGTH + "자 이상 " + GameInfo.MAX_CAR_NAME_LENGTH
        + "자 이하만 가능합니다."),
    ERROR_CAR_NAMES_BLANK("자동차 이름은 공백일 수 없습니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
