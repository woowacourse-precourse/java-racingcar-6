package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Car {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int position;

    public Car(String name) {
        position = 0;
        this.name = name;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
        if (randomNumber >= MOVE_CONDITION) {
            position++;
        }
    }

    public void printNameAndPosition() {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public boolean isWinner(List<Car> cars) {
        return cars.stream()
                .noneMatch(other -> other.position > position);
    }

    @Override
    public String toString() {
        return name;
    }
}
