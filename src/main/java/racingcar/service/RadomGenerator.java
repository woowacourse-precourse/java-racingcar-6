package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.random.RandomGenerator;

/* Random 생성기
*  0 ~ 9*/
public class RadomGenerator {
    private boolean result;
    public RadomGenerator() {
        this.result = generateRandom();
    }

    // random 생성
    public boolean generateRandom() {
        return randomResult(Randoms.pickNumberInRange(0,9));
    }

    // random 결과가 4이상이면 true
    public boolean randomResult(int random) {
        if (random >= 4) {
            return true;
        }
        return false;
    }
}
