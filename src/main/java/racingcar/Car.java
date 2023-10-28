package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int distance;
    final int STEP_PERCENTAGE = 4;  // 자동차가 이동할 확률 조정. 0~9까지 1씩 오를수록 10% 확률 감소.

    Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    @Override
    public String toString() {
        StringBuilder distanceStr = new StringBuilder();
        distanceStr.append(name + " : ");
        for(int i = 0; i < distance; i++) {
            distanceStr.append("-");
        }
        return distanceStr.toString();
    }

    void moveRandom() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if(randomNumber >= STEP_PERCENTAGE) {
            distance = distance + 1;
        }
    }
}
