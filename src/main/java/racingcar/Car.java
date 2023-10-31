package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryToMove() {
        if (canMove()) {
            moveForward();
        } else {
            stop();
        }
    }

    public boolean canMove() {
        int randomNum = Randoms.pickNumberInRange(
                            Constant.RANDOM_BEGIN,
                            Constant.RANDOM_END
                        );

        if (randomNum >= Constant.RANDOM_THRESHOLD) {
            return true;
        } else {
            return false;
        }
    }

    public void moveForward() {
        distance++;
    }

    public void stop() {
        return;
    }

    public void print() {
        System.out.println(this);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
