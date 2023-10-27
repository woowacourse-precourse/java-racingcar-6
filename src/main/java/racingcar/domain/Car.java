package racingcar.domain;

import java.util.function.BooleanSupplier;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;
    private final BooleanSupplier driveRule;
    private int drivingCount;

    public Car(String name, BooleanSupplier driveRule) {
        if (NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름의 최대 길이는 " + NAME_MAX_LENGTH + "까지입니다.");
        }

        this.name = name;
        this.driveRule = driveRule;
        this.drivingCount = 0;
    }

    public CarPosition drive() {
        if (driveRule.getAsBoolean()) {
            drivingCount++;
        }

        return new CarPosition(getName(), getDrivingCount());
    }

    public String getName() {
        return name;
    }

    public int getDrivingCount() {
        return drivingCount;
    }
}
