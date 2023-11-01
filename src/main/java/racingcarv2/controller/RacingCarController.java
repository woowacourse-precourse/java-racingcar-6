package racingcarv2.controller;

import java.util.stream.IntStream;
import racingcarv2.model.RacingCars;
import racingcarv2.model.RoundTotal;
import racingcarv2.util.converter.StringToCarList;
import racingcarv2.util.converter.StringToNumber;
import racingcarv2.view.InputView;
import racingcarv2.view.OutputView;

public class RacingCarController {
    public static final int START_INCLUSIVE = 0;

    public void run() {
        try {
            RacingCars racingCars = registerRacingCars();
            RoundTotal roundTotal = registerRoundTotal();
            displayRacingStatus(roundTotal, racingCars);
            displayWinner(racingCars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private RoundTotal registerRoundTotal() {
        OutputView.printInputRoundTotal();
        return new RoundTotal(StringToNumber.convert(InputView.inputRoundTotal()));
    }

    private RacingCars registerRacingCars() {
        OutputView.printInputCarNames();
        return new RacingCars(StringToCarList.convert(InputView.inputCarNames()));
    }

    private void displayRacingStatus(RoundTotal roundTotal, RacingCars racingCars) {
        OutputView.printRoundStatus();
        IntStream.range(START_INCLUSIVE, roundTotal.getRoundTotalValue())
                .forEach((num) -> OutputView.printEachRound(racingCars.moveAllCars()));
    }

    private void displayWinner(RacingCars racingCars) {
        OutputView.printWinnerNames(racingCars.findWinnerName());
    }
}
