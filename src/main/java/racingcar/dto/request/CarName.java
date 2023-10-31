package racingcar.dto.request;

public class CarName {

    private static final Integer MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateNameLength(name.length());
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(Integer nameLength) {
        if (nameLength > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
