package racingcar;

import racingcar.messages.Message;
import racingcar.view.InputView;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final List<Car> cars = new ArrayList<>();
    private int numOfExecutions;
    private final InputView inputView = new InputView();

    public void start() {
        System.out.println(Message.GAME_START_NAME);
        List<String> cars = inputView.readCars();
        for (String car : cars) {
            this.cars.add(new Car(car));
        }

        System.out.println(Message.GAME_START_COUNT);
        this.numOfExecutions = inputView.readNumOfExecutions();
    }
}
