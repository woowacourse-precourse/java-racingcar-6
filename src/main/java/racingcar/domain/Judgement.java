package racingcar.domain;

import java.util.*;

public class Judgement {
    public List<Integer> findWinner(int[] raceResult) {
        int maxNum = Arrays.stream(raceResult).max().getAsInt();

        //maxNum을 가지고 있는 모든 인덱스 반환
        List<Integer> maxIndex = new ArrayList<>();
        for (int i = 0; i < raceResult.length; i++){
            if (raceResult[i] == maxNum) {
                maxIndex.add(i);
            }
        }

        return maxIndex;
    }
}
