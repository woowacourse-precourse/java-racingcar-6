package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int distance;

    public Car(String name) {
        this.carName = name;
        this.distance = 0;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.distance++;
        }
    }

    public void printDistanceStatus() {
        System.out.println(this.carName + " : " + "-".repeat(this.distance));
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return carName;
    }

}



