package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public int calculateBestRecord(List<Integer> track){
        int bestRecord = 0;
        for (int currentPosition : track) {
            if (bestRecord <= currentPosition) {
                bestRecord = currentPosition;
            }
        }
        return bestRecord;

    }
    public List<Integer> findWinnerindex(List<Integer> track,int bestRecord) {
        List<Integer> winnerIndex = new ArrayList<>();

        for (int i = 0; i < track.size(); i++) {
            if (track.get(i) == bestRecord) {
                winnerIndex.add(i);
            }
        }
        return winnerIndex;
    }

    public void printResult(List<Integer> winnerIndex, String[] car) {
        System.out.print("최종 우승자 : " + car[winnerIndex.get(0)]);
        for (int i = 1; i < winnerIndex.size(); i++) {
            System.out.print(", " + car[winnerIndex.get(i)]);
        }
    }
}
