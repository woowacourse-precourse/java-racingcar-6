package racingcar.service;

import static racingcar.utill.Validator.carNameValidation;
import static racingcar.utill.Validator.duplicateCarNameValidation;
import static racingcar.view.RacingView.attemptNumberInputView;
import static racingcar.view.RacingView.carNameInputView;
import static racingcar.view.RacingView.winnerView;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarList;
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

    public void racingStart() {
        carNameInputView();
        CarList carList = new CarList(stringToCarListConvert(customReadLine.carsNameInput()), numberGenerator);
        attemptNumberInputView();
        carList.racing(customReadLine.attemptNumberInput());
        winnerView(carList.racingWinnerDecision());
    }

    private List<Car> stringToCarListConvert(String carsNameString) {
        List<Car> carList = new ArrayList<>();
        String[] splitName = carsNameString.split(",", -1);

        for (String name : splitName) {
            carNameValidation(name);
            carList.add(new Car(name));
        }

        duplicateCarNameValidation(carList);

        return carList;
    }

}
