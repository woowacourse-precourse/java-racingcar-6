package racingcar.validator;

public class CarNameValidator {

    public void checkCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5 이하로 설정 해주세요.");
        }
    }

    public void checkDuplicatedCarName() {

    }
}
