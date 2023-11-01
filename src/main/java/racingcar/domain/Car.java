package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final Integer CONDITION = 3;

    private String name;
    private Integer moveCount;

    public Car(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.moveCount = 0;
    }

    String getName() {
        return name;
    }

    Integer move() {
        if (generateRandom() > CONDITION) {
            this.moveCount++;
        }
        printResult();
        return this.moveCount;
    }

    private void printResult() {
        System.out.print(this.name + " : ");
        for(int i = 0; i < this.moveCount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    boolean isWinner(Integer moveCount) {
        if (moveCount == this.moveCount) {
            return true;
        }
        return false;
    }

    private Integer generateRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
