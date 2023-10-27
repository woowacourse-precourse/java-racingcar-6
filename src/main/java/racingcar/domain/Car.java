package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public void attemptMovingForward() {
        int random = Randoms.pickNumberInRange(0, 9);

        if (random < 4) {
            return;
        }
        position.increment();
    }

    public void printCar() {
        printName();
        printPosition();
    }

    private void printName() {
        name.print();
        System.out.print(" : ");
    }

    private void printPosition() {
        int currentPosition = position.getPosition();
        for (int i = 0; i < currentPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
