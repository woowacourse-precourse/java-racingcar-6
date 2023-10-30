package racingcar.model;

public class CarName {
    private String name;

    public CarName(String name) {
        if (name.length() < CarNameLength.MINIMUM.getValue() ||
                name.length() > CarNameLength.MAXIMUM.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_CAR_NAME.getMessage());
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
