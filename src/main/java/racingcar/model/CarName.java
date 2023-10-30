package racingcar.model;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    public String get() {
        return name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Car 이름의 길이는 최대 5자입니다.");
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException("Car 이름의 길이는 0이상입니다.");
        }
    }

}
