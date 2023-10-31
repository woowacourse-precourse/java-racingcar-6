package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import racingcar.utils.Utils;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    @Test
    void 랜덤으로_생성한_숫자가_0과_9사이면_통과() {
        //given
        int case1 = -1;
        int case2 = 10;

        //when
        int result1 = Utils.generateRandomNumber();
        int result2 = Utils.generateRandomNumber();

        //then
        assertThat(result1 > case1 && result1 < case2);
        assertThat(result2 > case1 && result2 < case2);
    }
}
