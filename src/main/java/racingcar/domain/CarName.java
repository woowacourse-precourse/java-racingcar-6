package racingcar.domain;

public class CarName {
    private String name;

    public CarName(String carName) {
        this.name = carName;
        validateCarName();
    }

    public void validateCarName() {
        isCarNameNull();
    }

    private void isCarNameNull() {
        if (name.length() > 0) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }
}
