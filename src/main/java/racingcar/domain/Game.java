package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

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
        CarName carName = new CarName(Console.readLine());
        return carName.getCarNameStrList();
    }

    private int getNumberOfAttempts() {
        Attemp attemp = new Attemp(Console.readLine());
        return attemp.getNumber();
    }

    private void play(List<String> carNameList) {

    }

    private void showResult() {

    }
}
