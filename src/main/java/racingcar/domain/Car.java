package racingcar.domain;

public class Car {

    public void validateCarName(String name) {
        if(name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 1~5 사이입니다.");
        }
    }
}
