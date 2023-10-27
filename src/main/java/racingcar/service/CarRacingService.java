package racingcar.service;

import static racingcar.utill.Validator.attemptNumberValidation;
import static racingcar.utill.Validator.carNameValidation;
import static racingcar.view.RacingView.attemptNumberInputView;
import static racingcar.view.RacingView.carNameInputView;
import static racingcar.view.RacingView.winnerView;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
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
        StringTokenizer splitCarToken = new StringTokenizer(carNameString, ",");
        while (splitCarToken.hasMoreTokens()) {
            String carName = splitCarToken.nextToken();
            carNameValidation(carName);
            carList.add(new Car(carName));
        }
        return carList;
    }
}
