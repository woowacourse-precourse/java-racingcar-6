package racingcar;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public void start() {
        List<String> carNames = InputView.inputCarNames();
        int numberOfTrials = InputView.inputNumberOfTrials();
        List<Car> cars = createRacingCars(carNames);
        RacingCars racingCars = new RacingCars(cars);
        run(numberOfTrials, racingCars);
    }

    private List<Car> createRacingCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void run(int numberOfTrials, RacingCars racingCars) {
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTrials; i++) {
            for (Car car : racingCars.getRacingCars()) {
                car.move();
            }
            OutputView.printRacingCars(racingCars);
        }
        OutputView.printWinner(racingCars);
    }


}
