package racingcar;

public class Car {
    private final String name;
    private int distance;

    Car(String name) {
        validateNullOrEmpty(name);
        validateLengthLimit(name);
        this.name = name;
    }

    private void validateNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }
    }

    private void validateLengthLimit(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public void go(RandomNumber randomNumber) {
        if (randomNumber.getNumber() >= 4) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }
}
