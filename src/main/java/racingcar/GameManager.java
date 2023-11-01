package racingcar;

import racingcar.view.InputView;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    public static final String DISTANCE_CHAR = "-";
    private final List<Car> cars = new ArrayList<>();
    private int numOfExecutions;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        outputView.printNameInputPrompt();

        List<String> cars = inputView.readCars();
        for (String car : cars) {
            this.cars.add(new Car(car));
        }

        outputView.printNumOfExecutionsInputPrompt();
        this.numOfExecutions = inputView.readNumOfExecutions();
    }

    public void play() {
        outputView.printGameResult();
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

            outputView.drawCarDistance(car);
        }

        System.out.print("\n");
    }

    public void printResult() {
        List<Car> winners = getMaxDistanceCars();
        outputView.printWinners(winners);
    }

    protected List<Car> getMaxDistanceCars() {
        int maxDistance = 0;
        List<Car> maxCars = new ArrayList<>();

        for (Car car : this.cars) {
            if (maxDistance == car.getDistance()) {
                maxCars.add(car);
            } else if (maxDistance < car.getDistance()) {
                maxCars.clear();
                maxCars.add(car);
                maxDistance = car.getDistance();
            }
        }

        return maxCars;
    }
}
