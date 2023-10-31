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

    public void playRacing() {
        int randomNumber = getRandomNumber();
        updateMovingCountOrNot(randomNumber);
        printResult();
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void updateMovingCountOrNot(int randomNumber) {
        if (randomNumber >= 4) {
            movingCount++;
        }
    }

    private void printResult() {
        String movingWay = getMovingWay();
        System.out.println(name + " : " + movingWay);
    }

    private String getMovingWay() {
        String movingWay = "";
        for (int i = 0; i < movingCount; i++) {
            movingWay += "-";
        }
        return movingWay;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(movingCount, car.movingCount);
    }
}
