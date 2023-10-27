package racingcar.service;

import racingcar.domain.Cars;
import racingcar.dto.CarsGenerateDto;
import racingcar.view.OutputView;

public class GameService {

    private final Rule rule;
    private final RandomNumberGenerator randomNumberGenerator;
    private final OutputView outputView;

    public GameService() {
        rule = new Rule();
        randomNumberGenerator = new RandomNumberGenerator();
        outputView = new OutputView();
    }

    public void playUntilTrialNumber(int trialNumber, CarsGenerateDto carsGenerateDto) {
        Cars generatedCars = createCars(carsGenerateDto);

        for (int i = 0; i < trialNumber; i++) {
            moveCarsByRandomNumber(generatedCars);
            outputView.showResult(carsGenerateDto.cars());
        }
    }

    private void moveCarsByRandomNumber(Cars cars) {
        cars.moveCars(rule, randomNumberGenerator);
    }

    private Cars createCars(CarsGenerateDto carsGenerateDto) {
        return new Cars(carsGenerateDto.cars(), carsGenerateDto.carsName());
    }
}

