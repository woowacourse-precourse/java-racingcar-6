package racingcar;

import java.util.List;

public class Car {

    private String name;
    private Integer forwardCount;

    private static final int DEFAULT_FORWARD_COUNT = 0;

    public Car(String name) {
        this.name = name;
        this.forwardCount = DEFAULT_FORWARD_COUNT;
    }

    public boolean isEqualName(String inputName) {
        return inputName.equals(name);
    }

    public void moveForward() {
        forwardCount++;
    }

    public void printCarName() {
        System.out.print(name + " : ");
    }

    public void printForwardCount() {
        System.out.println("-".repeat(forwardCount));
    }

    public boolean isEqualForwardCount(Integer inputForwardCount) {
        return forwardCount.equals(inputForwardCount);
    }

    public int findBiggerForwardCount(int forwardCount) {
        return Math.max(this.forwardCount, forwardCount);
    }

    public static void printWinnerCars(List<Car> winnerCars) {
        List<String> winnerCarsNames = winnerCars.stream()
                .map(car -> car.name)
                .toList();
        System.out.println(String.join(", ", winnerCarsNames));
    }
}
