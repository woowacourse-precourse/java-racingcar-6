package racingcar.model;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[Error]: 자동차 이름이 5자를 넘음");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}