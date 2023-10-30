package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarDto;
import racingcar.model.CarRepository;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    CarRepository carRepository = new CarRepository();
    Parser parser = new Parser();
    public void run() {
        prepareRace();
        outputView.requestNumberOfTryMessage();
        int num = Integer.parseInt(inputView.inputNumberOfTry());
        Race race = Race.from(num);

        while (race.isRunning()) {
            race.runSingleRace(carRepository.getCars());
            outputView.raceResultByOrderMessage(carRepository.getCars().stream().map(car -> CarDto.from(car)).toList());
        }

        outputView.raceResultMessage();
        outputView.raceWinnerMessage(carRepository.getWinner());
    }

    private void prepareRace() {
        outputView.requestCarNamesMessage();
        String inputNames = inputView.inputCarNamesToRace();
        List<String> names = parser.carNameParser(inputNames);
        for (String name : names) {
            carRepository.save(Car.from(name));
        }
    }
}
