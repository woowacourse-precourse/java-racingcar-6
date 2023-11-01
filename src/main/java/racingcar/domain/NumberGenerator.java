package racingcar.domain;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private static NumberGenerator numberGenerator;
    private NumberGenerator() {

    }
    public static NumberGenerator getInstance() {
        if (numberGenerator == null) {
            numberGenerator = new NumberGenerator();
        }
        return numberGenerator;
    }
    public int createRandomGenerator() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
