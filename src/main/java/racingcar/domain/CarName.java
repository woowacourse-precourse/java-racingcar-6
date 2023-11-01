package racingcar.domain;

public class CarName {

    private final String name;
    public CarName(String name) {
        checkCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkCarName(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException("err: 자동차 이름은 null이 될 수 없습니다.");
        }

        checkCarNameLength(carName);
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() < 1) {
            throw new IllegalArgumentException("err: 자동차 이름은 한 글자 이상이어야 합니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("err: 자동차 이름은 다섯 글자 이하만 가능합니다.");
        }
    }
}
