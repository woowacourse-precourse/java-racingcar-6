package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Application;
import racingcar.view.OutputView;

import java.util.HashMap;

public class RaceService {
    private static final int MIN_RANDOM_VALUE = 4;
    public void startRace(HashMap<String, String> participants, int round) {
        while (isRoundLeft(round)) {
            for (String car : participants.keySet()) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= MIN_RANDOM_VALUE) {
                    plusOneStep(participants, car);
                }
            }
            OutputView.showEachRoundResultOf(participants);
            round -= 1;
        }
    }

    public static boolean isRoundLeft(int round) {
        return round > 0;
    }

    private static void plusOneStep(HashMap<String, String> participants, String car) {
        String beforeRecord = participants.get(car);

        StringBuilder st = new StringBuilder();
        st.append(beforeRecord).append("-");

        participants.put(car, st.toString());
    }
}
