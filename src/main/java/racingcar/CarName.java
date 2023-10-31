package racingcar;

public class CarName {

    private String carName;

    public CarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름의 길이는 5를 초과할 수 없습니다.");
        }
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }
}
