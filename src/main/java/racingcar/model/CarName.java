package racingcar.model;

public class CarName {
    String name;
    static final int MAX_NAME_LENGTH = 5;

    public CarName(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }
}
