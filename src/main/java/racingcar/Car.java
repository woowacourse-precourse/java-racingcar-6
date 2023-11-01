package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private final String name;
    private int movingCount;

    public Car(String name) {
        this.name = name;
        this.movingCount = 0;
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
        if (randomNumber >= 4) {
            return movingCount++;
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
}
