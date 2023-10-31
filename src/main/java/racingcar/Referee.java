package racingcar;

import java.util.ArrayList;
import java.util.Collections;

public class Referee {
    public ArrayList<String> compare(ArrayList<Integer> lastGameResult, ArrayList<String> carList) {
        int maxScore = Collections.max(lastGameResult);
        ArrayList<String> winners = new ArrayList<>();

        for (int i = 0; i < carList.size(); i++) {
            if (lastGameResult.get(i) >= maxScore) {
                winners.add(carList.get(i));
            }
        }
        return winners;
    }

    public void printWinners(ArrayList<String> raceWinners) {
        String winnerAnnouncement = String.join(", ", raceWinners);
        System.out.println("최종 우승자 : " + winnerAnnouncement);
    }

}
