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

    void printCars(Car[] carArr) {      // 각 차의 실황 출력
        for (Car car: carArr) {
            String tempScore = "-".repeat(car.score);
            System.out.printf("%s : %s", car.name, tempScore);
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
