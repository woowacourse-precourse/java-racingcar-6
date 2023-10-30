package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Car implements Comparable<Car> {
    private static final int MAX_NAME_LENGTH = 5;

    String name;
    int moveCount;
    int index;

    public Car(String name, int index) {
        validateName(name);
        this.name = name;
        this.moveCount = 0;
        this.index = index;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw (new IllegalArgumentException());
        }
    }

    public void move() {
        if (canMove()) {
            moveCount++;
        }
    }

    private boolean canMove() {
        return (Randoms.pickNumberInRange(0, 9) <= 4);
    }

    public String path() {
        return (name + " : " + "-".repeat(moveCount));
    }

    public static String firstWinner(List<Car> carList) {
        Car first = carList.get(0);

        return first.name;
    }

    public static String winnerString(List<Car> carList) {
        String winners = "";
        Car firstCar = carList.get(0);

        for (Car car : carList) {
            if (car.lessMoves(firstCar)) {
                break;
            }
            winners = addWinner(car, winners);
        }
        return winners;
    }

    private boolean lessMoves(Car firstCar) {
        return moveCount < firstCar.moveCount;
    }

    private static String addWinner(Car car, String winners) {
        winners += ", ";
        winners += car.name;
        return winners;
    }

    @Override
    public int compareTo(Car other) {
        if (other.moveCount == this.moveCount) {
            return (this.index - other.index);
        }
        return (other.moveCount - this.moveCount);
    }
}
