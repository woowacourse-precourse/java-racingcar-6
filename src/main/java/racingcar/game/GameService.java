package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;

import java.util.List;
import java.util.stream.IntStream;

public class GameService {
    public static int Num_For_Win = 4;

    public void playRound(Cars cars) {
        List<String> names = cars.getName();
        List<Integer> scores = cars.getScore();
        IntStream.range(0, names.size())
                .filter(i -> isWin())
                .forEach(i -> scores.set(i, scores.get(i) + 1));
    }

    public boolean isWin() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number >= Num_For_Win;
    }
}