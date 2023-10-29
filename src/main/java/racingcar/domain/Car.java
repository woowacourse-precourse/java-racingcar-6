package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.util.Constants;

public class Car {
    private final String name;
    private int position = 0;

    private Car(final String name) {
        this.name = name;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public void move() {
        int randomNumber = randomNumberGenerator();

        if (isMoreThanForwardCondition(randomNumber)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public CarDto toCarDto() {
        return new CarDto(name, position);
    }
}
