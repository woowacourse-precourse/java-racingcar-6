package racingcar;

import java.util.List;
import racingcar.car.Car;
import racingcar.race.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Program {

    private final Race race;
    private final InputView inputView;
    private final OutputView outputView;


    public Program(int carNameMaxLength) {
        inputView = new InputView();
        outputView = new OutputView();

        List<Car> cars = registerCars(carNameMaxLength);
        race = new Race(cars);
    }

    public void run() {
        int runtime = inputGameRuntime();

        outputView.showStart();
        race.start(runtime);

        while (race.next()) {
            List<Car> cars = race.tick();
            outputView.showCarStatus(cars);
        }

        showWinners();
    }


    private List<Car> registerCars(int carNameMaxLength) {
        String delimiter = ",";
        outputView.askCarName(delimiter);
        List<String> carNames = inputView.inputStringSplitBy(delimiter);

        return carNames.stream()
                .map(carName -> new Car(carName, carNameMaxLength))
                .toList();
    }

    private int inputGameRuntime() {
        outputView.askGameRuntime();
        return inputView.inputDigit();
    }

    private void showWinners() {
        List<Car> winners = race.getWinners();
        outputView.showWinners(winners);
    }

}
