package racingcar.domain;

public class Car {

    private int distance;

    public void validateCarName(String name) {
        if(name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 1~5 사이입니다.");
        }
    }

    public void moveCar(int randomNumber) {
        if(randomNumber >= 4) {
            distance++;
        }
    }
}
