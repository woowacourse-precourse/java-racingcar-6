package racingcar.domain;

public class Name {
    private String value;

    private Name(String value) {
        this.value = value;
    }

    public static Name of(String value) {
        return new Name(value);
    }
}
