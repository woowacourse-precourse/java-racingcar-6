package racingcar.service;

import racingcar.domain.Cars;
import racingcar.dto.CarsGenerateDto;
import racingcar.view.OutputView;

public class GameService {

    private final Rule rule;
    private final OutputView outputView;
    private final Referee referee;
    private final RandomNumberGenerator randomNumberGenerator;

    public GameService() {
        rule = new Rule();
        outputView = new OutputView();
        referee = new Referee();
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public void playUntilTrialNumber(int trialNumber, CarsGenerateDto generatedCars) {
        Cars cars = Cars.generate(generatedCars);
        for (int i = 0; i < trialNumber; i++) {
            moveCarsByRandomNumber(cars);
            outputView.showResult(cars.getCarsList());
        }
        outputView.showWinner(referee, cars);
    }

    private void moveCarsByRandomNumber(Cars cars) {
        cars.moveAll(rule,randomNumberGenerator);
    }
}

