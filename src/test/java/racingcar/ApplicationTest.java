package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.utils.RandomNumberGenerater;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final RandomNumberGenerater randomNumberGenerater = new RandomNumberGenerater();

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_앞_공백_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ab, cd,ef,gh"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_뒤_공백_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ab,cd,ef ,gh"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,def,ghi", "1b"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 랜덤값이_3일때_값_변화() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP, STOP
        );
    }

    @Test
    void 쉼표만_이름으로_들어올떄(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
