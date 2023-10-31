package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RaceNumber {
    private int[] raceNumber;

    public int[] getRaceNumber() {
        return raceNumber;
    }

    public void createRaceNumber(List<String> carMembers) {
        int[] raceNumber = new int[carMembers.size()];
        for (int i = 0; i < carMembers.size(); i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                raceNumber[i] += 1;
            }
        }
        this.raceNumber = raceNumber;
    }
}
