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
    void 이름_빈칸_제거_처리_후_정상작동_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("po  bi,    won i,  eugen ", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "eugen : ", "최종 우승자 : pobi, woni, eugen");
                },
                STOP, STOP, STOP
        );
    }

    @Test
    void 한명_일_경우_게임_불가() {
        assertSimpleTest(
                () -> {
                    assertThatThrownBy(() -> runException("pobi", "1"))
                            .isInstanceOf(IllegalArgumentException.class);
                } // 혼자..게임은 슬프니까..
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
