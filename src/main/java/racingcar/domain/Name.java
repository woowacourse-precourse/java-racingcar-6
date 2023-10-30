package racingcar.domain;

public class Name {

    private static final int MAX_NAMING_LENGTH = 5;
    private String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAMING_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getLawName() {
        return name;
    }
}
