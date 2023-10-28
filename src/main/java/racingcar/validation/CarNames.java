package racingcar.validation;

public class CarNames {
    void checkNullInput(String in) throws IllegalArgumentException {
        if (in == null || in.isEmpty()) {
            throw new IllegalArgumentException("아무 입력도 들어오지 않았습니다.");
        }
    }
}
