package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RaceLogic {

    static void attemptAllRacer(Racer[] racers, boolean alwaysSuccess) {
        for(Racer racer : racers){
            attemptOnceWithRacer(racer, alwaysSuccess);
        }
    }

    static void attemptOnceWithRacer(Racer racer, boolean alwaysSuccess) {
        if (Randoms.pickNumberInRange(0, 9) >= 4 || alwaysSuccess) {
            racer.increaseProgress();
        }
    }

    static List<Racer> findWinner(Racer[] racers){
        List<Racer> winners = new ArrayList<>();
        int maxProgress = 0;

        for (Racer racer : racers) {
            int progress = racer.getProgress();
            if (progress > maxProgress) {
                maxProgress = progress;
            }
        }

        for (Racer racer : racers) {
            if (racer.getProgress() == maxProgress) {
                winners.add(racer);
            }
        }

        return winners;
    }
}
