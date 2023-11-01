package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Winner {


    public static List<String> pickWinners(Map<String, String> raceResultsHMap) {
        Set<Map.Entry<String, String>> raceResultsES = raceResultsHMap.entrySet();

        int maxRaceResultLength = getMaxResultLength(raceResultsES);

        List<String> winners = getWinnersArrayList(raceResultsES, maxRaceResultLength);

        return winners;
    }


    public static int getMaxResultLength(Set<Map.Entry<String, String>> raceResultsES) {
        int maxRaceResultLength = 0;

        for (var entry : raceResultsES) {
            String eachCarRaceResult = entry.getValue();
            if (eachCarRaceResult.length() >= maxRaceResultLength) {
                maxRaceResultLength = eachCarRaceResult.length();
            }
        }

        return maxRaceResultLength;
    }


    public static List<String> getWinnersArrayList(Set<Map.Entry<String, String>> raceResultsES, int maxRaceResultLength) {
        List<String> winners = new ArrayList<>();

        for (var entry : raceResultsES) {
            String eachCarRaceResult = entry.getValue();
            if (eachCarRaceResult.length() == maxRaceResultLength) {
                String winner = entry.getKey();
                winners.add(winner);
            }
        }

        return winners;
    }


    public static void showWinners(List<String> winnersArrayList) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winnersArrayList.size(); i++) {
            System.out.print(winnersArrayList.get(i));
            if (i < winnersArrayList.size() - 1) {
                System.out.print(", ");
            }
        }

    }


}

