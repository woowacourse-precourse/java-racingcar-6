package racingcar.model;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (!validateName(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        this.name = name;
    }

    private boolean validateName(String name) {
        return name.length() <= 5;
    }


    @Override
    public String toString() {
        return name;
    }
}
