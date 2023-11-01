package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        int checkMove = Randoms.pickNumberInRange(0, 9);

        if (checkMove >= 4) {
            this.position++;
        }
    }

    public  void showPosition() {
        String nowPosition = "";

        for (int i = 0; i < this.position; i++) {
            nowPosition += "-";
        }

        System.out.println((this.name + " : " + nowPosition));
    }
}
