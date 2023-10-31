package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {
    private int GoOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return 1;
        }
        return 0;
    }
    public List<Integer> Start(int attemptNumber, int racingCarCount) {
        List<Integer> advancementResult = new ArrayList<>(Collections.nCopies(racingCarCount, 0));
        for (int attempt = 0; attempt < attemptNumber; attempt++) {
            for (int i = 0; i < racingCarCount; i++) {
                advancementResult.set(i, advancementResult.get(i) + GoOrStop());
            }
            System.out.println(advancementResult);
        }
        return advancementResult;
    }
}
