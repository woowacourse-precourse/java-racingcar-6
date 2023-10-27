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
        // TODO 2023 10 28 문자열 조합은 컨트롤러에서 처리하고 주어진 List<String>만 출력만 담당하도록 수정한다.
        System.out.println();
    }

    public static void printFinalWinner(String winnerListString) {
        System.out.print(SystemMessage.FINAL_WINNER.getMessage() + winnerListString);
    }

    private static String parseProgressBar(Integer progress) {
        return IntStream.range(0, progress)
                .mapToObj(i -> "-")
                .collect(joining());
        // TODO 2023 10 28 마찬가지로 컨트롤러로 옮긴다. 뷰에서 처리할만한 연산 아님
    }
}
