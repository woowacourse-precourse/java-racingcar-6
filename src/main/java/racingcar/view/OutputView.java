package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.view.formatter.OutputFormatter;

import java.util.List;

public class OutputView {

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printResultMessage() {
        String result = OutputFormatter.makeResultMessage();
        System.out.println(result);
    }

    public static void printWinner(List<CarDto> winners) {
        String result = OutputFormatter.makeWinner(winners);
        System.out.println(result);
    }

    public static void printRoundResult(List<CarDto> players) {
        String result = OutputFormatter.makeRoundResult(players);
        System.out.println(result);
    }

}
