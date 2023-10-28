package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Round;

public class GameController {

    public GameController() {
        set();

    }

    public void set() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = InputController.setCars();

        System.out.println("시도할 회수는 몇회인가요?");
        int roundNumber = InputController.setRound();

        // Car 객체 생성 및 자동차 이름 할당
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

}
