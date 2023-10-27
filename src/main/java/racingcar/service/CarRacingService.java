package racingcar.service;

import static racingcar.utill.Validator.attemptNumberValidation;
import static racingcar.utill.Validator.carNameValidation;
import static racingcar.view.RacingView.attemptNumberInputView;
import static racingcar.view.RacingView.carNameInputView;
import static racingcar.view.RacingView.winnerView;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarList;

public class CarRacingService {

    public void racingStart() {
        carNameInputView();
        CarList carList = new CarList(stringToCarList(Console.readLine()));
        attemptNumberInputView();
        racing(carList, attemptStringToInt((Console.readLine())));
        winnerView(carList.racingWinnerDecision());
    }

    private void racing(CarList carList, int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            carList.carsStopOrMoveDecisionCall();
        }
    }

    private int attemptStringToInt(String stringValue) {
        attemptNumberValidation(stringValue);
        return Integer.parseInt(stringValue);
    }

    private List<Car> stringToCarList(String carNameString) {
        List<Car> carList = new ArrayList<>();
        String[] split = carNameString.split(",", -1);

        for (String a : split) {
            carNameValidation(a);
            carList.add(new Car(a));
        }

        return carList;
    }
}
