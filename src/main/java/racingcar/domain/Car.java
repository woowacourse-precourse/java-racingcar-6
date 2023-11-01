package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int FORWARD_THRESHOLD = 4;

    private Name name;
    private Move move;

    public Car(Name name, Move move) {
        this.name = name;
        this.move = move;
    }

    public Car(String carName) {
        this.name = new Name(carName);
        this.move = new Move();
    }

    public void moveForward() {
        if (generateRandomNumber() >= FORWARD_THRESHOLD) {
            move.increase();
        }
    }

    public int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        return randomNumber;
    }

    public void print() {
        System.out.println(name.toString() + " : " + move.toString());
    }

    public int getMoveCount() {
        return move.getMoveCount();
    }

    public String getCarName() {
        return name.toString();
    }
}
