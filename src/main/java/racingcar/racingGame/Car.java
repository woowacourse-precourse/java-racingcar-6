package racingcar.racingGame;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void tryMove() {

        int randNum = Randoms.pickNumberInRange(0, 9);

        if(randNum >= 4) {
            this.distance++;
        }
    }

}
