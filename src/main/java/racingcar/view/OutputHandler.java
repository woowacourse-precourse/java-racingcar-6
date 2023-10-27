package racingcar.view;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.system.SystemMessage;

public class OutputHandler {
    public static void printRaceProgressLabel() {
        System.out.print(SystemMessage.RACE_RESULT.getMessage());
    }

    public static void printRaceProgress(List<String> nameList, List<Integer> progressList) {
        int listSize = nameList.size();
        IntStream.range(0, listSize)
                .forEach(i -> System.out.println(nameList.get(i) + " : "
                        + parseProgressBar(progressList.get(i))));
        System.out.println();
    }

    public static void printFinalWinner(String winnerListString) {
        System.out.print(SystemMessage.FINAL_WINNER.getMessage() + winnerListString);
    }

    private static String parseProgressBar(Integer progress) {
        return IntStream.range(0, progress)
                .mapToObj(i -> "-")
                .collect(joining());
    }
}
