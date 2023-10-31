package racingcar.service;

import racingcar.domain.Cars;
import racingcar.dto.CarsGenerateDto;
import racingcar.view.OutputView;

public class GameService {

    private final BasicMovementRule basicMovementRule;
    private final OutputView outputView;
    private final Referee referee;
    private final RandomNumberGenerator randomNumberGenerator;

    public GameService() {
        basicMovementRule = new BasicMovementRule();
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
        cars.moveAll(basicMovementRule,randomNumberGenerator);
    }
}

