package racingcar.service;

import static racingcar.utill.Converter.attemptStringToInt;
import static racingcar.utill.Converter.stringToCarList;
import static racingcar.view.RacingView.attemptNumberInputView;
import static racingcar.view.RacingView.carNameInputView;
import static racingcar.view.RacingView.winnerView;

import camp.nextstep.edu.missionutils.Console;
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

}
