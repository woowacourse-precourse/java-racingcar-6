package racingcar.util;
import camp.nextstep.edu.missionutils.Randoms;

public class RaceNumGenerator {
    public int generateNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
