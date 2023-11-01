package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.util.ExceptionMessage;

public class Car {
    private static final int MIN_MOVE_SIZE = 0;
    private static final int MAX_MOVE_SIZE = 9;
    private static final int POSSIBLE_MOVE_STANDARD_SIZE = 4;
    private static final Pattern carNamePattern = Pattern.compile("^[a-z]*$");

    private final Name name;
    private Position position;

    public Car(Name name) {
        validateNameFormat(name.getName());
        this.name = name;
        this.position = new Position();
    }

    private void validateNameFormat(String name) {
        Matcher matcher = carNamePattern.matcher(name);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_FORMAT);
        }
    }

    void tryMove() {
        if (isMove()) {
            position.increase();
        }
    }

    private boolean isMove() {
        return Randoms.pickNumberInRange(MIN_MOVE_SIZE, MAX_MOVE_SIZE) >= POSSIBLE_MOVE_STANDARD_SIZE;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Car otherCar = (Car) other;
        return Objects.equals(this.name, otherCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
