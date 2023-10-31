package racingcar.Computer;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import racingcar.Constants.RandomNumberRange;

public class RandomNumber {
    public static int generate() {
        return pickNumberInRange(RandomNumberRange.MIN_RANDOM_RANGE, RandomNumberRange.MAX_RANDOM_RANGE);
    }
}