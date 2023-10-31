package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public void printPosition() {
        StringBuilder positionBuilder = new StringBuilder();

        positionBuilder.append(name + " : ");
        for (int i = 0; i < position; i++) {
            positionBuilder.append("-");
        }

        System.out.println(positionBuilder.toString());
    }

    public String getName() {
        return this.name;
    }
    
    public int getPosition() {
        return this.position;
    }
}
