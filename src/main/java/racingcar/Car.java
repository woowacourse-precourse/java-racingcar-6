package racingcar;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) { //예외 처리: 길이 조건
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
