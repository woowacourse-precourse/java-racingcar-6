package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.car.property.Name;
import racingcar.domain.car.property.Position;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Car(String name) {
        this(name, 0);
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
        System.out.println();
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
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}
