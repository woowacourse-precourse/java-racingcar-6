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
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름을_콤마로_구분안할경우(){
        assertSimpleTest(()->
                assertThatThrownBy(()->runException("pobi.jav","1"))
                        .isInstanceOf(IllegalArgumentException.class)
                );
    }
    @Test
    void 우승자가_한명일_경우(){
        assertRandomNumberInRangeTest(
                ()->{
                    run("pobi,woni","8");
                    assertThat(output()).contains("pobi : -","woni : ","최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }
    @Test
    void 공동_우승자_출력(){
        assertRandomNumberInRangeTest(
                ()->{
                    run("pobi,woni","8");
                    assertThat(output()).contains("pobi : --","woni : --","최종 우승자 : pobi, woni");
                },
                5,6
        );
    }

    @Test
    void 숫자가_아닌_값이_들어올_경우(){
        assertSimpleTest(()->
                assertThatThrownBy(()->runException("pobi.jav","n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_음수가_들어온_경우(){
        assertSimpleTest(()->
                assertThatThrownBy(()->runException("pobi.jav","-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
