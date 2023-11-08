package racingcar.innout;

import racingcar.domain.CarList;

import static racingcar.message.PrintMessage.*;

public class OutputPrint {

    public void printInputRacing() {
        System.out.println(INPUT_CAR_NAME.getMessage());
    }

    public void printInputTryCount() {
        System.out.println(INPUT_TRY_COUNT.getMessage());
    }

    public void printRacingStart() {
        System.out.println(PRINT_RACING_RESULT.getMessage());
    }

    public void printRacingLog(CarList group) {
        System.out.println(group.toProgressMessage());
    }

    public void printWinner(CarList group) {
        System.out.printf(PRINT_WINNER.getMessage(), group.toWinnerMessage());
    }
}
