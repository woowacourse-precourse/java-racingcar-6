package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final String name;
    public int randomNumber;
    public int distance;

    public RacingCar(String name) {
        this.name = name;
    }

    private void makeRandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
    }

    public void goOrStop() {
        makeRandomNumber();
        if (this.randomNumber >= 4) {
            this.distance++;
        }
    }

    public void printDistance() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public String getName() {
        return this.name;
    }
}
