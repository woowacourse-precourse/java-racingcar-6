package racingcar.resolver;

import racingcar.model.Cars;
import racingcar.service.RacingCarService;
import racingcar.service.TextProcessor;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCarRun {
    private final RacingCarService service;
    private final TextProcessor textProcessor;
    private final RacingCarView view;

    public RacingCarRun() {
        this.service = new RacingCarService();
        this.textProcessor = new TextProcessor();
        this.view = new RacingCarView();
    }

    public void run() {
        var cars = createCarsByInput(view.getCarNameInput());
        int count = getTryCountByInput(view.getTryCountInput());
        view.racingResultOutput();
        repeatMoveCar(cars, count);
        view.racingWinnerOutput(getRacingWinners(cars));
    }

    private Cars createCarsByInput(String carNames) {
        var separatorCarNames = textProcessor.splitCarNames(carNames);
        return service.createCars(separatorCarNames);
    }

    private int getTryCountByInput(String tryCount) {
        return textProcessor.parseTryNumber(tryCount);
    }

    private void repeatMoveCar(Cars cars, int count) {
        for (int i = 0; i < count; i++) {
            service.moveCars(cars);
            String output = textProcessor.carsDistanceAsString(cars);
            view.racingCarsDistanceOutput(output);
        }
    }

    private String getRacingWinners(Cars cars) {
        var winners = choiceRacingWinner(cars);
        return textProcessor.joinText(winners);
    }

    private List<String> choiceRacingWinner(Cars cars) {
        int maxDistance = service.maxCarDistance(cars);
        return service.getWinnerCarNames(cars, maxDistance);
    }
}
