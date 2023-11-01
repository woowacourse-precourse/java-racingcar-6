package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car implements Comparable<Car> {
    public static final int BASELINE_NUMBER_FOR_UPDATE = 4;
    private final String name;
    private int movingCount;

    public Car(String name, int movingCount) {
        this.name = name;
        this.movingCount = movingCount;
    }

    public String getName() {
        return name;
    }

    public int getMovingCount() {
        return movingCount;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public int updateMovingCountOrNot(int randomNumber) {
        if (randomNumber >= BASELINE_NUMBER_FOR_UPDATE) {
            return ++movingCount;
        }
        return movingCount;
    }

    public String getResult() {
        String movingWay = getMovingWay();
        return name + " : " + movingWay;
    }

    private String getMovingWay() {
        String movingWay = "";
        for (int i = 0; i < movingCount; i++) {
            movingWay += "-";
        }
        return movingWay;
    }

    public boolean isWinner(int maxCount) {
        if (movingCount == maxCount) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(movingCount, car.movingCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return movingCount == car.movingCount && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, movingCount);
    }
}
