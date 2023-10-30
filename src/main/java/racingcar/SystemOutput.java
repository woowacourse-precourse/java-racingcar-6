package racingcar;

import java.util.*;

public class SystemOutput {
    public void showStatus(String name, int location) {
        System.out.printf(name + " : ");
        for (int i = 0; i < location; i++) {
            System.out.printf("-");
        }
        System.out.println();
    }

    public void showResult(Map<String, Car> playedRacingPlayer) {
        Map<String, Integer> result = new HashMap<>();
        List<String> winnerList = new ArrayList<>();


        for (String name : playedRacingPlayer.keySet()) {
            result.put(name, playedRacingPlayer.get(name).getLocation());
        }
        int maxValue = Collections.max(result.values());

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getValue().equals(maxValue)){
                winnerList.add(entry.getKey());
            }
        }

        System.out.println("최종 주승자 : " + winnerList);
    }
}
