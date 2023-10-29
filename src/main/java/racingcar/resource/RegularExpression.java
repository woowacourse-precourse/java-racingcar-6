package racingcar.resource;

public enum RegularExpression {

    NUMBER_REGEX("^[0-9]+$");

    private String regExpString;

    RegularExpression(String regExpString) {
        this.regExpString = regExpString;
    }

    public String getValue() {
        return this.regExpString;
    }
}
