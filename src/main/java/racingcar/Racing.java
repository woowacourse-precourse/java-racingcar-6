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

    public void Start(int attemptNumber, List<String> racingCarName) {
        List<Integer> advancementResult = new ArrayList<>(Collections.nCopies(racingCarName.size(), 0));
        PrintResult printer = new PrintResult();

        System.out.println("\n실행 결과");
        for (int attempt = 0; attempt < attemptNumber; attempt++) {
            for (int i = 0; i < racingCarName.size(); i++) {
                advancementResult.set(i, advancementResult.get(i) + GoOrStop());
            }
            printer.PrintOneAttemptResult(advancementResult, racingCarName);
        }
        printer.PrintWinnerCarName(FindWinner(advancementResult), racingCarName);
    }

    private List<Integer> FindWinner(List<Integer> advancementResult) {
        List<Integer> winnerIndex = new ArrayList<>();

        int maxAdvancement = Collections.max(advancementResult);

        for (int i = 0; i < advancementResult.size(); i++) {
            if (advancementResult.get(i) == maxAdvancement) {
                winnerIndex.add(i);
            }
        }
        return winnerIndex;
    }
}
