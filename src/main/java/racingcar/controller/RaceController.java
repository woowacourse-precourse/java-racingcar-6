package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.service.CarFactoryService;
import racingcar.service.RaceService;
import racingcar.service.ValidationService;
import racingcar.view.InputView;

import java.util.List;

public class RaceController {

    private final RaceService raceService;
    private final ValidationService validationService;

    public RaceController() {
        this.raceService = new RaceService();
        this.validationService = new ValidationService();
    }

    private Race getRaceInput() {
        List<String> carNames = validationService.validateCarsRange(InputView.getCarNames());
        int rounds = validationService.validateRoundType(InputView.getRounds());
        validationService.validateCarsName(carNames);
        validationService.validateRoundRange(rounds);
        List<Car> cars = CarFactoryService.createCars(carNames);
        return new Race(cars, rounds);
    }

}
