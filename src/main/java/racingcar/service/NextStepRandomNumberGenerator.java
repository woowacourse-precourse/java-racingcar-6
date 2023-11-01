package racingcar.service;
import camp.nextstep.edu.missionutils.Randoms;
public class NextStepRandomNumberGenerator implements RandomNumberGenerator{
    @Override
    public int pickNumberInRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
