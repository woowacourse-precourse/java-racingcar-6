package racingcar;

import java.util.List;
import racingcar.domain.Input;
import racingcar.domain.Race;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = Input.readCarName();
        System.out.println("시도할 회수는 몇회인가요?");
        int moveCount = Input.readMoveCount();
        Race race = new Race(carNames, moveCount);
        race.start();
        race.evaluate();
    }
}