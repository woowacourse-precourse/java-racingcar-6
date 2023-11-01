package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {

    private final String name;
    private int position;

    private final String PROGRESS_BAR = "-";

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        validateName(name);
        return new Car(name, 0);
    }

    public static Car of(String name, int position) {
        validateName(name);
        return new Car(name, position);
    }

    public void move() {
        if (canMove()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber > 3;
    }

    private static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름에는 빈 문자열은 불가능합니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    @Override
    public String toString() {
        String position = PROGRESS_BAR.repeat(this.getPosition());
        return String.format("%s : %s", name, position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;

        if (position != car.position) {
            return false;
        }
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + position;
        return result;
    }
}
