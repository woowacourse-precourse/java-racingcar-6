package racingcar.domain.car;

import java.util.function.Supplier;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(Supplier<Integer> randomNumberSupplier) {
        if (randomNumberSupplier.get() >= 4) {
            position += 1;
        }
    }
}
