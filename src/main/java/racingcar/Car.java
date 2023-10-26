package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

class Car {
    private String name;
    private int position;

    Car() {
        position = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void run() {
        position += runningDistance();
    }

    private int runningDistance() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return 1;
        }
        return 0;
    }
}
