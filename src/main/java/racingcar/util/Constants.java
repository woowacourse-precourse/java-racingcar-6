package racingcar.util;

public enum Constants {
    GET_GREETING_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),

    //** error Message **/
    HAS_BLANK_IN_NAME("입력된 자동차 이름에 공백이 포함 되어 있습니다."),
    NOT_MATCH_MINIMUM_CAR_SIZE("경주 가능한 최소 차의 개수는 2대 입니다."),
    HAS_DUPLICATE_NAME("중복된 이름이 있습니다."),

    NAME_SPLIT_REGEX(","),
    MINIMUM_CAR_SIZE("2");

    public String constant;

    Constants(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
