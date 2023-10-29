package racingcar.controller;

import java.util.List;
import racingcar.model.CarRepository;
import racingcar.service.RaceService;
import racingcar.service.WinnerService;
import racingcar.view.View;

public class RaceControllerIntegerRanged implements RaceController {
    @Override
    public void processRace(String input, CarRepository carRepository) {
        int round = inputToInt(input);
        View.RaceStartMessage();
        RaceService.raceRepeatByInput(round, carRepository);

        List<String> winners = WinnerService.getWinnerNames(carRepository);
        View.printWinner(winners);
    }

    private int inputToInt(String input) {
        isValidInput(input);
        int round = Integer.parseInt(input);
        return round;
    }

    @Override
    public void isValidInput(String input) {
        try {
            int round = Integer.parseInt(input);
            if (round <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
