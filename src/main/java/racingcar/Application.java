package racingcar;

import racingcar.car.Car;
import racingcar.car.moving.MovingStrategy;
import racingcar.car.moving.ThresholdRandomMover;
import racingcar.racing.Racing;
import racingcar.racing.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int MIN_RANDOM_BOUND = 0;
    private static final int MAX_RANDOM_BOUND = 9;
    private static final int MOVING_THRESHOLD = 4;
    private static final MovingStrategy gameMovingStrategy =
            new ThresholdRandomMover(MIN_RANDOM_BOUND, MAX_RANDOM_BOUND, MOVING_THRESHOLD);

    public static void main(String[] args) {
        Racing racing = createRacing();
        RacingResult racingResult = racing.race();
        showRacingResult(racingResult);
    }

    private static Racing createRacing() {
        InputView inputView = new InputView();
        List<String> carNames = inputView.askCarNames();
        List<Car> cars = createCars(carNames);
        int roundNumber = inputView.askRoundNumber();
        return new Racing(cars, roundNumber);
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, gameMovingStrategy));
        }
        return cars;
    }

    private static void showRacingResult(RacingResult racingResult) {
        OutputView outputView = new OutputView();
        outputView.showRacingResult(racingResult);
    }
}
