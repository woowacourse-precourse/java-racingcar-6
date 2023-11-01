package racingcar;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Move {
    private boolean chance() {
        if (Randoms.pickNumberInRange(0, 9) < 4) {
            return false;
        }
        return true;
    }

    public void move(ArrayList<String> names, int times) {
        return;
    }
}
