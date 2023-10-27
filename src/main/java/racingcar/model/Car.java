package racingcar.model;

public class Car {
    private final String name;
    private int distance = 0;

    /**
     * 이름만 입력값으로 받으면 RandomNumberGenerator 이용
     */
    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
