package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public List<Integer> decisionWinner(List<Integer> track) {
        int bestRecord = 0;
        //최고기록 찾기
        List<Integer> winner = new ArrayList<>();
        for (int i = 0; i < track.size(); i++) {
            int temp = track.get(i);
            if (bestRecord <= temp) {
                bestRecord = temp;
            }
        }
        //최고기록에 맞는 car 찾기
        for (int i = 0; i < track.size(); i++) {
            if (track.get(i) == bestRecord) {
                winner.add(i);
            }
        }
        return winner;
    }

    public void printResult(List<Integer> winner, String[] car) {
        System.out.print("최종 우승자 : " + car[winner.get(0)]);
        for (int i = 1; i < winner.size(); i++) {
            System.out.print(", " + car[winner.get(i)]);
        }
    }
}
