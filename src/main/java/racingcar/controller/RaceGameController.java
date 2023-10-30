package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.writeNewlineMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = inputView.readCarNamesInput();

        outputView.writeNewlineMessage("시도할 회수는 몇회인가요?");
        int gameCount = inputView.readUserGameCountInput();

        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();

        Cars cars = new Cars(carList);
        for(int i = 0; i < gameCount; i++) {
            cars.driveOneRound(gameCount, 4);
            List<Car> drivingCars = cars.getCars();
            outputView.printRoundResult(drivingCars);
        }

        List<Car> winners = cars.getWinners();
        outputView.printWinners(winners);
    }
}
