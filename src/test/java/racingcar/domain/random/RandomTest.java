package racingcar.domain.random;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomTest {
    @Test
    void 랜덤_숫자_생성() {
        Random random = new Random();
        int number = random.generateRandomNumber();

        for(int i=0; i<100; i++){
            Assertions.assertThat(number).isBetween(0, 9);
        }
    }
}
