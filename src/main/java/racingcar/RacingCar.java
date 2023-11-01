package racingcar;

import racingcar.enums.ErrorMessages;

public class RacingCar implements Comparable<RacingCar> {
    private final String name;
    private int distance = 0;

    public RacingCar(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessages.UNDER_FIVE.getMessage());
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

    public boolean isSameDistance(RacingCar other) {
        return this.distance == other.distance;
    }

    @Override
    public int compareTo(RacingCar other) {
        return this.distance - other.distance;
    }
}
