package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 단독_우승자_출력_확인(){
        assertRandomNumberInRangeTest(
                ()  -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output()).contains("pobi : -", "woni : --", "jun : -",
                            "pobi : ---", "woni : -", "jun : ", "최종 우승자 : pobi");
                },
                4,5,4,6,4,3
        );
    }

    @Test
    void 공동_우승자_출력_확인(){
        assertRandomNumberInRangeTest(
                ()  -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output()).contains("pobi : -", "woni : --", "jun : -",
                            "pobi : --", "woni : -", "jun : ", "최종 우승자 : pobi, woni");
                },
                4,5,4,5,4,3
        );
    }

    @Test
    void 경주_참여_자동차_0대(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_길이_위반_예외_처리_길이0(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jun,,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_길이_위반_예외_처리_길이5_초과(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jun,pobibi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_이름_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
