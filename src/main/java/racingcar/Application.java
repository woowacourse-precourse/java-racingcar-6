package racingcar;

import racingcar.domain.Racing;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Racing race1 = Racing.createRacingWithInput();
        race1.startRacing();
    }
}
