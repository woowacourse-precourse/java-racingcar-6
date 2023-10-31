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
    public List<Integer> Start(int attemptNumber, List<String> racingCarName) {
        List<Integer> advancementResult = new ArrayList<>(Collections.nCopies(racingCarName.size(), 0));
        PrintResult printer = new PrintResult();
        System.out.println("실행 결과");
        for (int attempt = 0; attempt < attemptNumber; attempt++) {
            for (int i = 0; i < racingCarName.size(); i++) {
                advancementResult.set(i, advancementResult.get(i) + GoOrStop());
            }
            printer.PrintOneAttemptResult(advancementResult, racingCarName);
        }
        return advancementResult;
    }
}
