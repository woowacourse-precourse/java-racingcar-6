package racingcar.model;

public class CarName {
    private final String name;
    private final int MAX_LENGTH = 5;
    private final String ERROR_MESSAGE = "[Error]: 자동차 이름이 5자를 넘음";

    public CarName(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
