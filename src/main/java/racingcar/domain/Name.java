package racingcar.domain;

public class Name {

    private static final int NAMING_LENGTH_BOUND = 5;
    private String name;

    public Name(String name) {

        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {

        if (name.length() > NAMING_LENGTH_BOUND) {
            throw new IllegalArgumentException();
        }
    }

    public String getLawName() {
        return name;
    }
}
