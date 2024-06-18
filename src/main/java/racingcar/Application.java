package racingcar;

import racingcar.domain.Racing;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Racing racing = Racing.registerCarList();
        racing.racingStart();
    }
}
