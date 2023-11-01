package racingcar.util;

public enum Constants {
    GET_GREETING_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    GET_ROUND_COUNT("시도할 회수는 몇회인가요?"),
    RESULT_CONSTANT("실행 결과"),
    WINNER_RESULT("최종 우승자"),
    NAME_SPLIT_REGEX(","),
    WINNER_SPLIT_FORMAT(", "),
    ROUND_REGEX("^[1-9][0-9]*$"),
    OUTPUT_FORMAT(" : "),
    MINIMUM_CAR_SIZE("2"),
    NAME_MAX_SIZE("5"),
    MINIMUM_DISTANCE_SIZE("4"),
    GENERATE_RANDOM_MIN_VALUE("0"),
    GENERATE_RANDOM_MAX_VALUE("9"),

    //** error Message **/
    HAS_BLANK_IN_NAME("입력된 자동차 이름에 공백이 포함 되어 있습니다."),
    NOT_MATCH_MINIMUM_CAR_SIZE("경주 가능한 최소 차의 개수는 2대 입니다."),
    HAS_DUPLICATE_NAME("중복된 이름이 있습니다."),
    EXCEED_NAME_SIZE("이름은 "+ NAME_MAX_SIZE + "글자 이상일 수 없습니다."),
    IS_NOT_NUMBER("1이상의 숫자가 아닙니다.");

    public String constant;

    Constants(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
