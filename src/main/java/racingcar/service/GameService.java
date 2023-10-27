package racingcar.service;

import racingcar.domain.Cars;
import racingcar.dto.CarsGenerateDto;
import racingcar.view.OutputView;

public class GameService {

    private final Rule rule;
    private final RandomNumberGenerator randomNumberGenerator;
    private final OutputView outputView;

    private final Referee referee;

    public GameService() {
        rule = new Rule();
        randomNumberGenerator = new RandomNumberGenerator();
        outputView = new OutputView();
        referee = new Referee();
    }

    public void playUntilTrialNumber(int trialNumber, CarsGenerateDto generatedCars) {
        Cars cars = Cars.generateCars(generatedCars);
        for (int i = 0; i < trialNumber; i++) {
            moveCarsByRandomNumber(cars);
            outputView.showResult(cars.getCarsList());
        }
        outputView.showWinner(referee, cars);
    }

    private void moveCarsByRandomNumber(Cars cars) {
        cars.moveCars(rule, randomNumberGenerator);
    }
}

