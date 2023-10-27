package racingcar;

public class ErrorHandler {

    public void checkErrorCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("잘못된 자동차 이름 입력입니다!!");
        }
    }
}
