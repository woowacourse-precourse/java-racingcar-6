package racingcar;

import racingcar.messages.Message;
import racingcar.view.InputView;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    public static final String DISTANCE_CHAR = "-";
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

    public void play() {
        System.out.println(Message.GAME_RESULT);
        for (int i = 0; i < numOfExecutions; i++) {
            runGame();
        }
    }
    protected void runGame() {
        for (Car car : cars) {
            int distance = Randoms.pickNumberInRange(0, 9);
            if (distance >= 4) {
                car.move(distance);
            }

            System.out.printf("%s : %s\n", car.getName(), DISTANCE_CHAR.repeat(car.getDistance()));
        }

        System.out.print("\n");
    }
}
