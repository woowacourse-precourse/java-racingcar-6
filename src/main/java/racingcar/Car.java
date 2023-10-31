package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomMove = Randoms.pickNumberInRange(0, 9);
        if (randomMove >= 4) {
            this.position++;
        }
    }

    public void show() {
        StringBuilder info = new StringBuilder();

        info.append(this.name);
        info.append(" : ");
        for (int i = 0; i < this.position; i++) {
            info.append("-");
        }

        System.out.println(info);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isAt(int position) {
        if (this.position == position) {
            return true;
        }
        return false;
    }
}
