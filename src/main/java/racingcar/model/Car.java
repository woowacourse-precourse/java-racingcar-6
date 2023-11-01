package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Car implements Comparable<Car> {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String COLON = " : ";
    private static final String PATH_UNIT = "-";
    private static final String EMPTY_STRING = "";
    private static final String COMMA = ", ";

    String name;
    int index;
    int moveCount;

    public Car(String name, int index) {
        validateName(name);
        this.name = name;
        this.index = index;
        this.moveCount = 0;
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
        return (Randoms.pickNumberInRange(0, 9) >= 4);
    }

    public String path() {
        return (name + COLON + PATH_UNIT.repeat(moveCount));
    }

    public static String winnerString(List<Car> carList) {
        String winners = EMPTY_STRING;
        Car firstCar = carList.get(0);

        for (Car car : carList) {
            if (car.lessMoves(firstCar)) {
                break;
            }
            winners = addWinner(car, firstCar, winners);
        }
        return winners;
    }

    private boolean lessMoves(Car firstCar) {
        return moveCount < firstCar.moveCount;
    }

    private static String addWinner(Car car, Car firstCar, String winners) {
        if (car != firstCar) {
            winners += COMMA;
        }
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
