package racingcar;

import java.util.Map;

public class Grandprix {
    SystemOutput systemOutput = new SystemOutput();

    public void playGrandprix(int numberOfTry, Map<String,Car> racingPlayer) {
        for (int i = 0; i < numberOfTry; i++) {
            for (String player : racingPlayer.keySet()) {
                racingPlayer.get(player).goOrStop();
                systemOutput.showStatus(player, racingPlayer.get(player).getLocation());
            }
            System.out.println();
        }
    }
}