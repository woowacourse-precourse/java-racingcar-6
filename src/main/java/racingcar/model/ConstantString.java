package racingcar.model;

public enum ConstantString {
    NAME_IS("%s : "),
    UNIT_MOVE("-");

    private final String string;

    ConstantString(String string) {
        this.string = string;
    }

    public String string() {
        return string;
    }
}
