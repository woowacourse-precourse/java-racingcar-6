package racingcar.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.util.NameValidator;
import racingcar.util.NumberGenerator;

public class Car implements Comparable<Car>{
    private static final int FORWARD_CONDITION_NUMBER = 4;
    private static final int RANDOM_RANGE_START_NUMBER = 0;
    private static final int RANDOM_RANGE_END_NUMBER = 9;

    private final String name;
    private int movementCount;

    public Car(String name, int movementCount) {
        NameValidator.checkNameLength(name);

        this.name = name;
        this.movementCount = movementCount;
    }

    public void forward() {
        int randomNumber = NumberGenerator.generateRandomNumberInRange(RANDOM_RANGE_START_NUMBER,
                RANDOM_RANGE_END_NUMBER);
        if (randomNumber >= FORWARD_CONDITION_NUMBER) {
            this.movementCount++;
        }
    }

    public String resultMessage() {
        String hyphenStr = IntStream.rangeClosed(1, this.movementCount)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());

        return name + " : " + hyphenStr;
    }

    public boolean isSameMovementCountBy(Car targetCar) {
        return this.movementCount == targetCar.movementCount;
    }

    protected String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Car car) {
        return this.movementCount - car.movementCount;
    }

}
