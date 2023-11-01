package racingcar.wrapper;

public class CarName {
    
    private final String name;
    
    private CarName(final String name) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name.trim();
    }

    public static CarName create(final String name) {
        return new CarName(name);
    }

    private void validateNameBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
