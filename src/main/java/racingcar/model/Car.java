package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getForward() {
        return this.forwardCount;
    }

    private void randomNumber() {
        int num = Randoms.pickNumberInRange(0,9);
        if (num >= 4) {
            forwardCount++;
        }
    }

    private void currentLocation() {
        System.out.print(name + " : ");
        for(int i = 0; i < forwardCount; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
