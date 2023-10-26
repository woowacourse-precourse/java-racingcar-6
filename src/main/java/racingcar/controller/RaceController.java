package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.TryRemains;
import racingcar.view.InputHandler;

public class RaceController {
    TryRemains tryRemains;
    List<Car> carList;

    RaceController() {
        createTryRemains(InputHandler.inputNumberOfTry());
    }

    void createTryRemains(String userInput) {
        tryRemains = new TryRemains(Integer.parseInt(userInput));
    }

    //TODO 2023-10-27 12:37:21 CarController에 List<Car>를 반환하는 메서드를 만들고 그 리스트를 받아온다.
}
