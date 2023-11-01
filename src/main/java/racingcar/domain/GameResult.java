package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {
    public static final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";
    public static final String COMMA_OUTPUT_MESSAGE = ", ";
    public static final String ATTEMPTS_COLON_MESSAGE = " : ";
    public static final String CAR_POSITION_SYMBOL = "-";

    public void singleAttemptResult(List<Map.Entry<String, Integer>> list) {
        for(Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey()
                    + ATTEMPTS_COLON_MESSAGE
                    + CAR_POSITION_SYMBOL.repeat(entry.getValue()));
        }
        System.out.print("\n");
    }

    public void printWinner(List<Map.Entry<String, Integer>> list) {
        System.out.print(WINNER_OUTPUT_MESSAGE);
        List<Integer> indexOfWinner = findIndexOfWinner(list);
        String winner = list.get(indexOfWinner.get(0)).getKey();
        System.out.print(winner);
        for(int i = 1; i < indexOfWinner.size(); i++) {
            String coWinner = list.get(indexOfWinner.get(i)).getKey();
            System.out.print(COMMA_OUTPUT_MESSAGE +  coWinner);
        }
    }

    public List<Integer> findIndexOfWinner(List<Map.Entry<String, Integer>> list) {
        List<Integer> score = list.stream()
                .map(Map.Entry::getValue)
                .toList();
        int maxScore = Collections.max(score);

        return IntStream.range(0, score.size())
                .filter(i -> score.get(i) == maxScore)
                .boxed()
                .collect(Collectors.toList());
    }
}
