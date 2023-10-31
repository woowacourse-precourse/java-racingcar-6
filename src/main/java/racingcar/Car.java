package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Optional;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void printMoves() {
        System.out.println(this.name + " : " + "-".repeat(this.position));
    }

    public void trial() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        this.position += Optional.of(randomNumber)
                .filter(n -> n >= 4)
                .map(n -> 1)
                .orElse(0);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
