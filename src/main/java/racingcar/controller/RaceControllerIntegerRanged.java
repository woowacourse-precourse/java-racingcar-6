package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.model.car.Car;
import racingcar.model.CarRepository;
import racingcar.service.RaceService;
import racingcar.service.WinnerService;
import racingcar.view.View;

public class RaceControllerIntegerVer implements RaceController {
    @Override
    public void processRace(String input, CarRepository carRepository) {

        View.RaceStartMessage();

        RaceService.raceRepeatByInput(input, carRepository);

        List<String> winners = WinnerService.getWinnerNames(carRepository);
        View.printWinner(winners);
    }
    @Override
    public void validateRoundInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
