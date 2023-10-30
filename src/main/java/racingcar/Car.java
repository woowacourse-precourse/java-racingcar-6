package racingcar;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        // 이름이 5글자 이하인지 검증
        if (name == null || name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상, 5글자 이하로 설정해 주세요.");
        }
    }
    public void goForward() {
        distance++;
    }


    // getter
    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
