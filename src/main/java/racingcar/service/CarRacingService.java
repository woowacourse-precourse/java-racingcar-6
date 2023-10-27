package racingcar.service;

import static racingcar.utill.Converter.attemptStringToIntCovert;
import static racingcar.utill.Converter.stringToCarListConvert;
import static racingcar.view.RacingView.attemptNumberInputView;
import static racingcar.view.RacingView.carNameInputView;
import static racingcar.view.RacingView.winnerView;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarList;

public class CarRacingService {

    public void racingStart() {
        carNameInputView();
        CarList carList = new CarList(stringToCarListConvert(Console.readLine()));
        attemptNumberInputView();
        racing(carList, attemptStringToIntCovert((Console.readLine())));
        winnerView(carList.racingWinnerDecision());
    }

    private void racing(CarList carList, int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            carList.carsStopOrMoveDecisionCall();
        }
    }

}
