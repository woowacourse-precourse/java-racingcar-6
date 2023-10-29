package racingcar.view;

import racingcar.dto.CarDto;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printWinner(List<CarDto> winners) {
        String result = winners.stream()
                .map(c -> c.name())
                .collect(Collectors.joining(", ", "최종 우승자 : ", ""));
        System.out.println(result);
    }

    public static void printRoundResult(List<CarDto> players) {
        players.stream()
                .forEach(c -> printRoundResultPlayer(c.name(), c.position()));
    }

    private static void printRoundResultPlayer(String name, int position) {
        System.out.println(name + " : " + makeDash(position));
    }

    private static String makeDash(int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> "-")
                .collect(Collectors.joining(""));
    }
}
