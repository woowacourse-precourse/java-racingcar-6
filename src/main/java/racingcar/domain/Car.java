package racingcar.domain;

import racingcar.util.GenerateRandomNumber;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public void move() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isCanMove() {
        int random = GenerateRandomNumber.getRandomNumber();
        if (random >= 4) {
            return true;  //이동
        }
        return false; //이동하지 않기
    }
}
