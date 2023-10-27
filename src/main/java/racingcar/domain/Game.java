package racingcar.domain;

import java.util.List;

public class Game {
    public void start() {
        /**
         * 1. 차 이름 입력 받기
         * 2. 시도 횟수 입력 받기
         * 3. 실행
         * 4. 실행 결과 표시
         */
        List<String> carNameList = getCarName();
        int numberOfAttempts = getNumberOfAttempts();
        for (int count = 0; count < numberOfAttempts; count++) {
            play(carNameList);
            showResult();
        }
    }

    private List<String> getCarName() {
        return null;
    }

    private int getNumberOfAttempts() {
        return 0;
    }

    private void play(List<String> carNameList) {

    }

    private void showResult() {

    }
}
