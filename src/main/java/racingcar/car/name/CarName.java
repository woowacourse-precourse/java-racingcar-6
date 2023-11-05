package racingcar.car.name;

public record CarName(String name) {

    public CarName {
        if (!name.matches("^[a-z]{1,5}$")) {
            throw new IllegalArgumentException("자동차 이름은 1-5자 영어 소문자만 가능합니다.");
        }
    }
}
