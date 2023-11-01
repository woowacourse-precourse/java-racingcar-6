package racingcar.console;

import racingcar.constants.Constants;

public class Output {

    public static void printCarState(String name, int position) {
        System.out.println(String.format(Constants.CAR_STATE_FORMAT.<String>getValue() , name, Constants.CAR_POSITION_SYMBOL.<String>getValue().repeat(position)));
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinner(String winners) {
        System.out.println(String.format(Constants.WINNER_MESSAGE.<String>getValue() , winners));
    }
}
