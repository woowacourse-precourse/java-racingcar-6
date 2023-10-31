package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.util.Util;

class UtilTest {
    static Util util;

    @BeforeAll
    static void beforeAll() {
        util = new Util();
    }
    @Test
    void 랜덤_숫자_생성기능_테스트() {
        //given
        //when
        int randomNumber = util.generateRandomNumber();
        //then
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    void 랜덤_숫자가_4_이상인지_판단기능_테스트() {
        //given
        int canForwardNumber = 5;
        //when
        boolean result = util.isUpperThanCanForwardNumber(canForwardNumber);
        //then
        assertThat(result).isTrue();
    }

    @Test
    void 랜덤_숫자가_4_미만인지_판단기능_테스트() {
        //given
        int canForwardNumber = 2;
        //when
        boolean result = util.isUpperThanCanForwardNumber(canForwardNumber);
        //then
        assertThat(result).isFalse();
    }
}