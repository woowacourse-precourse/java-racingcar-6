package racingcar;

import java.util.HashMap;

public class RacingGame {

    CarList carList;
    int count;

    public RacingGame() {
        retrieveCarList();
        // 이동 횟수 불러오기
        /*
         * 이동 횟수만큼 아래 과정 반복
         *
         * 1. 각 자동차별로 0~9사이의 무작위 값 구하기
         * 2. 해당 값이 4보다 큰지 확인
         * 3. 4이상이면 전진
         */
    }

    private void retrieveCarList() {
        CarList carlist = new CarList();
    }

}
