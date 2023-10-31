package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    public String computeTrack() {
        int number = Randoms.pickNumberInRange(0, 9);

        if (number >= 4) {
            return "-";
        } else {
            return "";
        }
    }

    public void printTrack(List<String> carNames, List<String> tracks) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");

            String track = tracks.get(i);
            track += computeTrack();
            tracks.set(i, track);

            System.out.print(track + "\n");
        }
    }

}
