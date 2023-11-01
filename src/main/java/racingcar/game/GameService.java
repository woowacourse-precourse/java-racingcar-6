package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
    public static int Num_For_Win = 4;

    public boolean isWin() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number >= Num_For_Win;
    }
}