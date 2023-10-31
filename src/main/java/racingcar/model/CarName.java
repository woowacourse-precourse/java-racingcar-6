package racingcar.model;

public class CarName {
    private final int MIN_NAME_LENGTH = 1;
    private final int MAX_NAME_LENGTH = 5;
    private final String SPACE = " ";
    private final String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    private void validateCarName(String name) {
        validateCarNameLength(name);
        validateCarNameHasNoSpace(name);
    }

    private void validateCarNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameHasNoSpace(String name) {
        if (name.contains(SPACE)) {
            throw new IllegalArgumentException();
        }
    }
}
