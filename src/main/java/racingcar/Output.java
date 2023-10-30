package racingcar;

import java.util.List;
import java.util.stream.Collectors;

final class Output {

    private Output() {
    }

    static void printInputNames() {
        System.out.println(OutputMessage.INPUT_NAMES.message);
    }

    static void printInputCount() {
        System.out.println(OutputMessage.INPUT_COUNT.message);
    }

    static void printResult() {
        System.out.println(OutputMessage.RESULT.message);
    }

    static void printGameResult(final List<String> result) {
        result.forEach(System.out::println);
        System.out.println();
    }

    static void printWinner(final List<String> winner) {
        String winnerOutput = winner.stream()
                .collect(Collectors.joining(Constant.COMMA.value + " "));
        System.out.println(OutputMessage.WINNER.message + winnerOutput);
    }
}
