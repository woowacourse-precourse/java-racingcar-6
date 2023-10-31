package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
        }
        this.name = name;
    }

    public void move() {
        int number = Randoms.pickNumberInRange(0,9);
        if (number >= 4) {
            position++;
        }
    }

    public void printPosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
