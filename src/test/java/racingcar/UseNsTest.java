package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UseNsTest extends NsTest {

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                4, 3
        );
    }

    @Test
    void 기본_테스트1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,khan", "1");
                    assertThat(output()).contains("최종 우승자 : khan");
                },
                3, 3, 4
        );
    }

    @Test
    void 기본_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,khan", "2");
                    assertThat(output()).contains("pobi : ", "woni : ", "khan : -","khan : --", "최종 우승자 : khan");
                },
                3, 3, 4, 3, 3, 4
        );
    }

    @Test
    void 이름_5자초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,aaaaaa", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 이름_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void n_잘못된_타입() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}