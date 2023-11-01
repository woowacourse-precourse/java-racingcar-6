package racingcar.domain;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public int createRandomNumber() {
        int number;
        number = Randoms.pickNumberInRange(0, 9);
        return number;
    }
}
