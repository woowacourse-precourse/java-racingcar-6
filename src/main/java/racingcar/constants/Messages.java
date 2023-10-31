package racingcar.constants;

public enum Messages {
    // INPUT
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요. (이름은 " + GameInfo.SEPARATOR_NAME + "(" + GameInfo.SEPARATOR
        + ") 기준으로 구분)"),
    INPUT_CAR_NAMES_ERROR("자동차 이름은 " + GameInfo.SEPARATOR_NAME + "로 구분되며 공백은 허용되지 않습니다."),
    INPUT_ROUND_NUM_ERROR("시도 횟수는 "+GameInfo.MIN_ROUND_NUM+"~"+GameInfo.MAX_ROUND_NUM+" 사이의 숫자여야 합니다."),
    INPUT_ROUND_NUM("시도할 회수는 몇 회 인가요?"),

    // OUTPUT
    OUTPUT_RESULT_HEADER("실행 결과"),
    OUTPUT_WINNER_PREFIX("최종 우승자 : ");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
