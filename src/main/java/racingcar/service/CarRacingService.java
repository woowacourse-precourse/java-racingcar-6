package racingcar.service;

import static racingcar.utill.Converter.stringToCarListConvert;
import static racingcar.utill.Converter.stringToIntCovert;
import static racingcar.utill.InputReadLine.attemptNumberInput;
import static racingcar.utill.InputReadLine.carsNameInput;
import static racingcar.view.RacingView.attemptNumberInputView;
import static racingcar.view.RacingView.carNameInputView;
import static racingcar.view.RacingView.winnerView;

import racingcar.domain.CarList;

public class CarRacingService {

    public void racingStart() {
        carNameInputView();
        CarList carList = new CarList(stringToCarListConvert(carsNameInput()));
        attemptNumberInputView();
        carList.racing(stringToIntCovert(attemptNumberInput()));
        winnerView(carList.racingWinnerDecision());
    }

}
