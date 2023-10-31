package racingcar.utils;

public enum Constants {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ATTEMPTS("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    WINNER("최종 우승자 : "),

    LENGTH_EXCEPTION("ERROR: 1글자 이상 5글자 이하의 이름을 입력하세요"),
    DUPLICATE_EXCEPTION("ERROR: 중복되지 않는 이름을 입력하세요"),
    INVALID_INPUT_EXCEPTION("ERROR: 허용되지 않은 입력입니다"),
    INVALID_REPETITION_EXCEPTION("ERROR: 잘못된 횟수 입력입니다"),

    NAME_VALIDATION_REGEX("^[가-힣\\w]+[가-힣\\w,]*[가-힣\\w]$"),
    //NAME_VALIDATION_REGEX("^[가-힣\\w]+(,[가-힣\\w]+)*$"),
    NUMBER_VALIDATION_REGEX("^[1-9]\\d*$"),
    SPACE_REGEX("\\s")
    ;

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
