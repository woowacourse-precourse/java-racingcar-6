package racingcar;

public class RacingCar {
    private final String name;
    private int distance = 0;

    public RacingCar(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void move(int number) {
        if (number >= 4) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
