package racingcar.service;

import static racingcar.utill.Validator.carNameValidation;
import static racingcar.utill.Validator.duplicateCarNameValidation;
import static racingcar.view.RacingView.executionResultView;
import static racingcar.view.RacingView.inputAttemptNumberView;
import static racingcar.view.RacingView.inputCarNameView;
import static racingcar.view.RacingView.newLine;
import static racingcar.view.RacingView.raceResultView;
import static racingcar.view.RacingView.winnerView;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.CarRacingResponse;
import racingcar.domain.RandomNumberGenerator;
import racingcar.utill.CustomReadLine;
import racingcar.utill.NumberGenerator;

public class CarRacingService {
    private final NumberGenerator numberGenerator;
    private final CustomReadLine customReadLine;

    public CarRacingService() {
        this.numberGenerator = new RandomNumberGenerator();
        this.customReadLine = new CustomReadLine();
    }

    public void startRacing() {
        inputCarNameView();
        CarList carList = new CarList(convertStringToCarList(customReadLine.carsNameInput()), numberGenerator);
        inputAttemptNumberView();
        int attemptNumber = customReadLine.attemptNumberInput();
        race(carList, attemptNumber);
        winnerView(carList.decisionRacingWinner());
    }

    private List<Car> convertStringToCarList(String carsNameString) {
        List<Car> carList = new ArrayList<>();
        String[] splitName = carsNameString.split(",", -1);

        for (String name : splitName) {
            carNameValidation(name);
            carList.add(new Car(name));
        }

        duplicateCarNameValidation(carList);

        return carList;
    }

    private void race(CarList carList, int attemptNumber) {
        executionResultView();
        for (int i = 0; i < attemptNumber; i++) {
            List<CarRacingResponse> carsResponses = carList.decisionCarsMoveOrStop1();
            carsResponses.forEach(carResponse -> raceResultView(carResponse.getCarName(),
                    carResponse.getCarPosition()));
            newLine();
        }
    }
}
