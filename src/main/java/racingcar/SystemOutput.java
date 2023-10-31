package racingcar;

import java.util.*;

public class SystemOutput {

    //플레이 중 진행 상황 출력
    public void showStatus(String name, int location) {
        System.out.printf(name + " : ");
        for (int i = 0; i < location; i++) {
            System.out.printf("-");
        }
        System.out.println();
    }


    //게임 진행 후 결과 출력
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

        String winnerListOut = String.join(", ", winnerList);

        System.out.printf("최종 우승자 : " + winnerListOut);
    }
}
