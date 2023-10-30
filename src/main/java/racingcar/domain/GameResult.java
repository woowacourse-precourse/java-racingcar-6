package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {
    public static final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";
    public static final String COMMA_OUTPUT_MESSAGE = ", ";
    public static final String ATTEMPTS_COLON_MESSAGE = " : ";
    public static final String CAR_POSITION_SYMBOL = "-";

    private List<String> carsNameList = new ArrayList<>();

    public void setCarsNameList(List<String> input) {
        carsNameList = input;
    }
    public void singleAttemptResult(List<Integer> carsPositionList) {
        for(int i = 0; i < carsPositionList.size(); i++) {
            System.out.println(carsNameList.get(i)
                    + ATTEMPTS_COLON_MESSAGE
                    + CAR_POSITION_SYMBOL.repeat(carsPositionList.get(i)));
        }
        System.out.print("\n");
    }

    public void printWinner(List<Integer> list) {
        System.out.print(WINNER_OUTPUT_MESSAGE);
        List<Integer> indexOfWinner = findIndexOfWinner(list);
        String winner = carsNameList.get(indexOfWinner.get(0));
        System.out.print(winner);
        for(int i = 1; i < indexOfWinner.size(); i++) {
            String coWinner = carsNameList.get(indexOfWinner.get(i));
            System.out.print(COMMA_OUTPUT_MESSAGE +  coWinner);
        }
    }

    public List<Integer> findIndexOfWinner(List<Integer> list) {
        int maxScore = Collections.max(list);
        return IntStream.range(0, list.size())
                .filter(i -> list.get(i) == maxScore)
                .boxed()
                .collect(Collectors.toList());
    }
}
