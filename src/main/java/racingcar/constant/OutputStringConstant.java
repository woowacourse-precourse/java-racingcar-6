package racingcar.constant;

public enum OutputStringConstant {

    INIT_SHOW_RESULT("실행 결과"),
    SHOW_WINNER("최종 우승자 : "),
    BLANK(" "),
    OUTPUT_NAME_DIVIDER(", ");

    private String value;

    OutputStringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
