package racingcar;

enum Constant {
    COMMA(","),
    COLON(" : "),
    DASH("-"),
    ;

    String value;

    Constant(String value) {
        this.value = value;
    }
}
