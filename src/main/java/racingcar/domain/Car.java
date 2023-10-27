package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int moves;

    public Car(String name) {
        this.name = name;
        this.moves = 0;
    }


    public void moveForward() {
        int num = getRandomNumber();
        if (num >= 4) {
            this.moves += 1;
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void printMoves() {
        System.out.print(name + " : ");
        for (int i = 0; i < moves; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
