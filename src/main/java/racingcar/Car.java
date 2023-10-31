package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

class Car {
    private String name;
    private Integer position;

    Car() {
        position = 0;
    }

    public void setName(String inputCarName) {
        name = inputCarName;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void run() {
        position += runningDistance();
    }

    private Integer runningDistance() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return 1;
        }
        return 0;
    }
}
