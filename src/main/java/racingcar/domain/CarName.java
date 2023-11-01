package racingcar.domain;

public class CarName {

    public static final int MAX_LENGTH = 5;

    private String name;

    public CarName(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 초과로 입력할 수 없습니다. " + name);
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}