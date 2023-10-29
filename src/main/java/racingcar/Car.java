package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int goCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getGoCount() {
        return goCount;
    }

    public String getName() {
        return name;
    }

    public void goOrStop() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            goCount++;
        }
    }

    public void printNameAndCount() {
        System.out.print(name + " : ");
        for (int i = 0; i < goCount; i++) {
            System.out.print("-");
            if (i != goCount - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
