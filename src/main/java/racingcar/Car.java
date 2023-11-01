package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {

    public static final int LIMIT = 4;
    private final String name;
    public static final int MAX_NAME_LENGTH = 5;
    private int mile = 0;

    public Car(String name) {
        verifyName(name);
        this.name = name;
    }

    private void verifyName(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("car name can't be null");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("car name length should be under " + MAX_NAME_LENGTH);
        }
    }

    public boolean isSame(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("car can't be null");
        }
        return Objects.equals(this.name, car.name);
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (canMove(randomNumber)) {
            this.mile ++;
        }
        System.out.println(this.name + " : " + "-".repeat(this.mile));
    }

    private boolean canMove(int mile) {
        return mile >= LIMIT;
    }
}
