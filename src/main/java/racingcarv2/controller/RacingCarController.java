package racingcarv2.controller;

import racingcarv2.model.RacingCars;
import racingcarv2.model.RoundTotal;
import racingcarv2.util.converter.StringToCarList;
import racingcarv2.view.InputView;
import racingcarv2.view.OutputView;

public class RacingCarController {
    public void run() {
        registerInformation();
    }

    private void registerInformation() {
        RacingCars racingCars = registerCarsByNames();

    }

    private RacingCars registerCarsByNames() {
        OutputView.printInputCarNames();
        return new RacingCars(StringToCarList.convert(InputView.inputCarNames()));
    }

    private void registerRoundTotal() {
        OutputView.printInputRoundTotal();
        InputView.inputRoundTotal();
    }

    private void displayRacingStatus(RoundTotal roundTotal, RacingCars racingCars) {
    }

    private void displayWinner(RacingCars racingCars) {

    }




}
