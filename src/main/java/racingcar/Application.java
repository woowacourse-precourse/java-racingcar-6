package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Racing;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Racing race1 = Racing.createRacingWithInput();
        race1.start();
        race1.printEachTurn();
        race1.printWinners();
    }
}
