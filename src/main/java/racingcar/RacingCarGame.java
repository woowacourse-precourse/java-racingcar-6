package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    InputProcessor inputProcessor;

    List<Car> cars;

    public RacingCarGame() {
        cars = new ArrayList<>();
        inputProcessor = new InputProcessor();
    }

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = inputProcessor.getCarNameListInput();
    }
}
