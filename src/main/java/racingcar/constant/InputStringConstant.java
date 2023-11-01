package racingcar.constant;

public enum InputStringConstant {

    GET_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    GET_ROUND_NUM("시도할 회수는 몇회인가요?"),
    BLANK(" "),
    INPUT_NAME_DIVIDER(",");

    private final String value;

    InputStringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
