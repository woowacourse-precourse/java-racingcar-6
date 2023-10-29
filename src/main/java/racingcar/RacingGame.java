package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    CarList carList;
    int count;

    public RacingGame() {
        retrieveCarList();
        retrieveCount();

        for (int i=0; i<count; i++) {
            /*
             * 1. 각 자동차별로 0~9사이의 무작위 값 구하기
             * 2. 해당 값이 4보다 큰지 확인
             * 3. 4이상이면 전진
             */

        }
    }

    private void retrieveCarList() {
        CarList carlist = new CarList();
    }

    private void retrieveCount() {
        User user = new User();
        count = user.initCount();
    }

    private void checkMoving(String carName) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            carList.moveForward(carName);
        }
    }

}
