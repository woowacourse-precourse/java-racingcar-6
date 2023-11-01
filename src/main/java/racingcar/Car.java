package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static constant.ConstantNumber.*;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goOrStop() {
        int number = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        if(number >= THRESHOLD) {
            go();
        }
        printDistance();
    }

    public int getDistance() {
        return distance;
    }

    private void printDistance() {
        System.out.print(name + " : ");
        for(int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void go() {
        distance++;
    }

    public String getName() {
        return name;
    }
}
