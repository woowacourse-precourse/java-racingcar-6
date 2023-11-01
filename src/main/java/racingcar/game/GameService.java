package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;

import java.util.Map;

public class GameService {
    public static int Num_For_Win = 4;

    public void playRound(Cars cars) {
        Map<String, Integer> state = cars.getState();
        state.replaceAll((name, score) -> {
            if (isWin()) {
                score += 1;
            }
            return score;
        });
    }

    public boolean isWin() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number >= Num_For_Win;
    }
}