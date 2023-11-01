package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int score;

    public Car(String name) {
        nameCheck(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void nameCheck(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.score++;
        }
    }

    public void print() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.score; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}