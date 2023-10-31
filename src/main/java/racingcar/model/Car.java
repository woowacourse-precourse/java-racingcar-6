package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int score = 0;


    public Car(String name) {
        this.name = name;
    }

    public void setRandomScore() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.score += 1;
        }
    }

    public void printInfo() {
        System.out.printf("%s : %s\n", this.name, "-".repeat(this.score));
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }


}
