package racingcar;

public class Car {
    private static final int LENGTH_LIMITER = 5;

    private final String name;
    private int point;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.point = 0;
    }

    private void validateLength(String name) {
        if (name.length() > LENGTH_LIMITER) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다");
        }
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void forward() {
        point += 1;
    }
}
