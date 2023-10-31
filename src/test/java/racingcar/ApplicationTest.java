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
    void 포비_크롱_공동_우승(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,crong", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi, crong");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
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
    void 이름_중복에_대한_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,crong,pobi","2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("중복된 이름이 있습니다!")
        );
    }
    @Test
    void 횟수_입력중_정수가_아닌값에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,crong", "pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("양의 정수를 입력해주세요!")
        );
    }
    @Test
    void 횟수_입력중_양수가_아닌값에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "-3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("양의 정수를 입력해주세요!")
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
