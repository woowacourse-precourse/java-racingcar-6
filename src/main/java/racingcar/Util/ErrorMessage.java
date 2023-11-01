package racingcar.Util;

public enum ErrorMessage {
    EMPTY("올바르지 않은 입력입니다."),
    NAME("올바르지 않은 입력입니다. 자동차 이름은 5자 이하만 가능합니다.\n올바른 예) pobi,woni,jun\n"),
    ATTEMPT("올바르지 않은 입력입니다. 숫자만 입력해 주세요."),
    DUPLICATION("올바르지 않은 입력입니다. 중복된 입력입니다.");

    private final String label;

    ErrorMessage(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
