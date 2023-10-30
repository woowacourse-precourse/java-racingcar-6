package racingcar;

import java.util.List;

public class Car {

    private static final int DEFAULT_FORWARD_COUNT = 0;
    private static final int KEY_NUMBER = 4;

    private String name;
    private Integer forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = DEFAULT_FORWARD_COUNT;
    }

    public String getName() {
        return name;
    }

    public boolean isEqualName(String inputName) {
        return inputName.equals(name);
    }

    public int compareNumberAndMove(int randomNumber) {
        if (randomNumber >= KEY_NUMBER) {
            forwardCount++;
        }
        return forwardCount;
    }

    public boolean isEqualForwardCount(Integer inputForwardCount) {
        return forwardCount.equals(inputForwardCount);
    }

    public int findBiggerForwardCount(int forwardCount) {
        return Math.max(this.forwardCount, forwardCount);
    }

    public static List<String> getCarsNames(List<Car> cars) {
        return cars.stream()
                .map(car -> car.name)
                .toList();
    }
}
