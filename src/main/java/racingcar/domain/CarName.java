package racingcar.domain;

public class CarName {
    private String name;

    public CarName(String carName) {
        this.name = carName;
        validateCarName();
    }

    public void validateCarName() {
        isCarNameNull();
        isCommaPresent();
    }

    private void isCarNameNull() {
        if (name.length() > 0) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }

    private void isCommaPresent() {
        if (name.contains(",")) {
            throw new IllegalArgumentException(",(쉼표)로 자동차 이름을 구분해주세요.");
        }
    }
}
