package racingcar.car;

public class Name {

    private final String value;

    public Name(final String value) {
        NameValidator.validate(value);
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
