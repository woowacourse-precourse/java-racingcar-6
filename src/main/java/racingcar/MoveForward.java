package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveForward {

    void moveCars(Car[] carArr) {      // 각 차를 이동 여부 결정
        for (Car car: carArr) {
            if (getRandomNumber()) {
                car.score += 1;
            }
        }
    }


    boolean getRandomNumber() {     // 전진 여부 구하기
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
