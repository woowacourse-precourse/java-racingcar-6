package racingcar;

import java.util.List;

public class Car {

    private static final int DEFAULT_FORWARD_COUNT = 0;
    private static final int KEY_NUMBER = 4;
    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final String CAR_NAME_OUTPUT_DELIMITER = ", ";

    private String name;
    private Integer forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = DEFAULT_FORWARD_COUNT;
    }

    public boolean isEqualName(String inputName) {
        return inputName.equals(name);
    }

    public void compareNumberAndMove(int randomNumber) {
        if (randomNumber >= KEY_NUMBER) {
            forwardCount++;
        }
    }

    public void printCarName() {
        System.out.print(name + COLON);
    }

    public void printForwardState() {
        System.out.println(DASH.repeat(forwardCount));
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
        System.out.println(String.join(CAR_NAME_OUTPUT_DELIMITER, winnerCarsNames));
    }
}
