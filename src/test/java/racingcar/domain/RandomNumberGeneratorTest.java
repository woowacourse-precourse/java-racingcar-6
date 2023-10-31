package racingcar.domain;

import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.Randoms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @Test
    void 랜덤값이_4이상일때_true반환(){


    }

    @Test
    void 지정된_범위의_랜덤(){
        int number = Randoms.pickNumberInRange(0,9);
        assertThat(number).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

}