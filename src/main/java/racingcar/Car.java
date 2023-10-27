package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

class Car {
    String name;
    int location = 0;

    public void moveForward() {
        int number = Randoms.pickNumberInRange(0, 9);

        if (number > 3) {
            location++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(location);
    }
}