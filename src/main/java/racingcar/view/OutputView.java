package racingcar.view;

import racingcar.dto.CarDto;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String DELIMITER_COMMA = ",";

    private static final int START_POSITION = 0;

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printWinner(List<CarDto> winners) {
        String result = winners.stream()
                .map(c -> c.name())
                .collect(Collectors.joining(DELIMITER_COMMA + SPACE, WINNER_MESSAGE, EMPTY_STRING));
        System.out.println(result);
    }

    public static void printRoundResult(List<CarDto> players) {
        players.stream()
                .forEach(c -> printOnePlayerRoundResult(c.name(), c.position()));
    }

    private static void printOnePlayerRoundResult(String name, int position) {
        System.out.println(name + " : " + makeDash(position));
    }

    private static String makeDash(int position) {
        return IntStream.range(START_POSITION, position)
                .mapToObj(i -> DASH)
                .collect(Collectors.joining(EMPTY_STRING));
    }
}
