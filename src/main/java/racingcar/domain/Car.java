package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private Name name;
    private Move move;

    public Car(String carName) {
        this.name = new Name(carName);
        this.move = new Move();
    }

    public void moveForward() {
        if (generateRandomNumber() >= 4) {
            move.increase();
        }
    }

    public int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
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
