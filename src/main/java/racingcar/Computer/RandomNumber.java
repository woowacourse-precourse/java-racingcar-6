package racingcar.Computer;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    public static int generate() {
        return pickNumberInRange(0, 9);
    }
}