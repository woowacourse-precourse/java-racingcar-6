package racingcar;

import java.util.Map;

public class Grandprix {
    SystemOutput systemOutput = new SystemOutput();

    public Map<String,Car> playGrandprix(int numberOfTry, Map<String,Car> racingPlayer) {
        for (int i = 0; i < numberOfTry; i++) {
            System.out.println("실행 결과");
            for (String player : racingPlayer.keySet()) {
                racingPlayer.get(player).goOrStop(0, 9);
                systemOutput.showStatus(player, racingPlayer.get(player).getLocation());
            }
            System.out.println();
        }
        return racingPlayer;
    }
}