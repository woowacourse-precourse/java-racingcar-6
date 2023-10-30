package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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
    void 이름에_대한_예외_처리_빈문자열_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching("RacingCar name length error"));
    }

    @Test
    void 이름에_대한_예외_처리_빈문자열_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" abc , , def", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching("RacingCar name length error"));
    }

    @Test
    void 이름에_대한_예외_처리_5글자_초과_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcdef", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching("RacingCar name length error"));
    }

    @Test
    void 이름에_대한_예외_처리_5글자_초과_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcde,abcdef,abcd", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching("RacingCar name length error"));
    }

    @Test
    void 이름에_대한_예외_처리_이름중복_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,abc", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching("RacingCar name duplicated error"));
    }

    @Test
    void 이름에_대한_예외_처리_이름중복_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,def, abc", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching("RacingCar name duplicated error"));
    }

    @Test
    void 시도할_횟수에_대한_예외_처리_형식에러_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,def", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching("tryNumber format error"));
    }

    @Test
    void 시도할_횟수에_대한_예외_처리_형식에러_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,def", "5a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching("tryNumber format error"));
    }

    @Test
    void 시도할_횟수에_대한_예외_처리_형식에러_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,def", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching("tryNumber format error"));
    }

    @Test
    void 시도할_횟수에_대한_예외_처리_범위에러_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,def", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching("tryNumber range error"));
    }

    @Test
    void 시도할_횟수에_대한_예외_처리_범위에러_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,def", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching("tryNumber range error"));
    }

    @Test
    void 시도할_횟수에_대한_예외_처리_범위에러_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,def", "-123"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching("tryNumber range error"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
