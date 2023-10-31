package racingcar.constant;

public enum StringConstant {

    PATTERN("^[a-zA-Z]*$"),
    SPACE(" "),
    REGEX(","),
    INPUT_CAR_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    INPUT_ROUND_NUMBER_MESSAGE("시도할 회수는 몇회인가요?\n"),
    OUTPUT_RESULT_MESSAGE("실행 결과\n"),
    OUTPUT_WINNER_MESSAGE("최종 우승자 : ");
    private final String message;

    StringConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
