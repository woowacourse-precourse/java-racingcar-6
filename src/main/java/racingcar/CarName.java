package racingcar;

import racingcar.utils.StringValidator;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private void validateName(String name) throws IllegalArgumentException {
        // 사용해도 되나?? static import
        if (StringValidator.isBlank(name)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_IS_BLANK);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_IS_TOO_LONG);
        }
    }

    public CarName(String name) throws IllegalArgumentException {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }
}
