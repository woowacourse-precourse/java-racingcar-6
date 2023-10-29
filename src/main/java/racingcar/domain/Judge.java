package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Judge {
    public int findMaxTrack(List<String> tracks) {
        int maxTrack = 0;

        for (int i = 0; i < tracks.size(); i++) {
            String currentTrack = tracks.get(i);
            int currentLength = currentTrack.length();

            if (currentLength > maxTrack) {
                maxTrack = currentLength;
            }
        }
        return maxTrack;
    }

    public List<String> findWinner(List<String> carNames, int maxTrack) {
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            if (carNames.get(i).length() == maxTrack){
                winners.add(carNames.get(i));
            }
        }
        return winners;
    }
}
