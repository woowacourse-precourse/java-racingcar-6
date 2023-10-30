package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.domain.car.Car;

public class GameView {
    public void printCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCountInput() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
