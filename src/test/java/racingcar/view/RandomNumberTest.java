package racingcar.view;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.util.MoveCar;

import static org.assertj.core.api.Assertions.*;

public class RandomNumberTest {

    @Test
    void 랜덤_숫자_테스트(){

        // given
        int min = 0;
        int max = 9;

        // when
        int result = Randoms.pickNumberInRange(min, max);

        // then
        assertThat(result).isBetween(min, max);

    }

}
