package racingcar.view;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.system.SystemMessage;

public class OutputHandler {
    public static void printRaceProgress(List<String> nameList, List<Integer> progressList) {
        int listSize = nameList.size();
        System.out.print(SystemMessage.RACE_RESULT.getMessage());
        IntStream.range(0, listSize)
                .forEach(i -> System.out.println(nameList.get(i) + " : "
                        + IntStream.range(0, progressList.get(i))
                        .mapToObj(j -> "-")
                        .collect(joining())));
        System.out.println();
    }
}
