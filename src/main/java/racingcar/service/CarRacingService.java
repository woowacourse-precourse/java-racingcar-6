package racingcar.service;

import static racingcar.utill.Validator.validateCarName;
import static racingcar.utill.Validator.validateDuplicatedCarName;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.dto.CarRacingResponse;
import racingcar.utill.CustomReadLine;
import racingcar.utill.NumberGenerator;
import racingcar.view.RacingView;

public class CarRacingService {
    private final NumberGenerator numberGenerator;
    private final CustomReadLine customReadLine;
    private final RacingView racingView;

    public CarRacingService() {
        this.numberGenerator = new RandomNumberGenerator();
        this.customReadLine = new CustomReadLine();
        this.racingView = new RacingView();
    }

    public void runCarRacing() {
        racingView.inputCarsNameView();
        Cars cars = new Cars(convertStringToCarList(customReadLine.inputCarsName()), numberGenerator);
        racingView.inputAttemptNumberView();
        int attemptNumber = customReadLine.inputAttemptNumber();
        raceCars(cars, attemptNumber);
        racingView.winnerView(cars.decisionWinner());
    }

    private List<Car> convertStringToCarList(String carsName) {
        List<Car> cars = new ArrayList<>();
        String[] splitName = carsName.split(",", -1);

        for (String name : splitName) {
            validateCarName(name);
            cars.add(new Car(name));
        }

        validateDuplicatedCarName(cars);

        return cars;
    }

    private void raceCars(Cars cars, int attemptNumber) {
        racingView.executionResultView();
        for (int i = 0; i < attemptNumber; i++) {
            List<CarRacingResponse> carsResponses = cars.decisionCarsMove();
            carsResponses.forEach(carResponse -> racingView.raceResultView(carResponse.getName(),
                    carResponse.getPosition()));
            racingView.newLine();
        }
    }
}
