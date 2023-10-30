package racingcarv2.controller;

import java.util.stream.IntStream;
import racingcarv2.model.RacingCars;
import racingcarv2.model.RoundTotal;
import racingcarv2.util.converter.StringToCarList;
import racingcarv2.util.converter.StringToNumber;
import racingcarv2.view.InputView;
import racingcarv2.view.OutputView;

public class RacingCarController {
    public void run() {
        init();
    }

    private void init() {
        RacingCars racingCars = getCarsByNames();
        RoundTotal roundTotal = getRoundTotal();
        displayRacingStatus(roundTotal, racingCars);
    }

    private RacingCars getCarsByNames() {
        OutputView.printInputCarNames();
        return new RacingCars(StringToCarList.convert(InputView.inputCarNames()));
    }

    private RoundTotal getRoundTotal() {
        OutputView.printInputRoundTotal();
        return new RoundTotal(StringToNumber.convert(InputView.inputRoundTotal()));
    }

    private void displayRacingStatus(RoundTotal roundTotal, RacingCars racingCars) {
        OutputView.printRoundStatus();
        IntStream.range(0, roundTotal.getRoundTotalValue())
                .forEach((num) -> OutputView.printEachRound(racingCars.moveAllCars()));

        displayWinner(racingCars);
    }

    private void displayWinner(RacingCars racingCars) {
        OutputView.printWinnerNames(racingCars.findWinner());
    }
}
