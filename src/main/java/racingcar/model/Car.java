package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int forwardCount;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getForwardCount() {
        return this.forwardCount;
    }

    public void move() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            forwardCount++;
        }
    }

    public void currentLocation() {
        System.out.print(name + " : ");
        for (int i = 0; i < forwardCount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
