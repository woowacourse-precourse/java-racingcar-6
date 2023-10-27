package racingcar.controller;

import java.util.List;

public class GameController {

    public GameController() {
        set();
    }

    public void set() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> setCars = InputController.setCars();
        System.out.println("시도할 회수는 몇회인가요?");
        int number = InputController.setNumber();
    }
}
