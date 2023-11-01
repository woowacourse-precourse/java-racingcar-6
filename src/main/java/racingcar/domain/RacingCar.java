package racingcar.domain;

import racingcar.util.RacingCarConstant;

public class RacingCar {

    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        String trimmedName = name.trim();
        if (trimmedName.length() > RacingCarConstant.CAR_NAME_MAX_LENGTH || trimmedName.isEmpty()) {
            throw new IllegalArgumentException(RacingCarConstant.CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
        this.name = trimmedName;
    }
    public void move() {
        int randomValue = RandomNumGenerator.generate();
        if (randomValue >= RacingCarConstant.MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
