package racingcar.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {
    private List<String> carsNameList = new ArrayList<>();

    public void setCarsNameList(List<String> input) {
        carsNameList = input;
    }
    public void singleAttemptResult(List<Integer> carsPositionList) {
        for(int i = 0; i < carsPositionList.size(); i++) {
            System.out.println(carsNameList.get(i) + " : " + "-".repeat(carsPositionList.get(i)));
        }
        System.out.print("\n");
    }

    public void findWinner(List<Integer> list) {
        System.out.print("최종 우승자 : ");
        List<Integer> indexOfWinner = findIndexOfWinner(list);
        System.out.print(carsNameList.get(indexOfWinner.get(0)));
        for(int i = 1; i < indexOfWinner.size(); i++) {
            System.out.print(", " +  carsNameList.get(indexOfWinner.get(i)));
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
