package racingcar.domain2;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    CarGame carGame = new CarGame();

    @Test
    void 지정된_범위의_랜덤(){
        int number = Randoms.pickNumberInRange(0,9);
        assertThat(number).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }








}