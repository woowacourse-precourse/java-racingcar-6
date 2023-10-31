package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest extends NsTest {
    private static final int MOVING_FORWARD = 8;
    Computer computer = new Computer();
    Output output = new Output();
    @Test
    void 이름_공백_무효_처리() {
        String testName = "   pobi";
        assertThat(computer.removeBlank(testName)).isEqualTo("pobi");

    }

    @Test
    void 자동차가_한_대_일_경우(){
        assertSimpleTest(() ->{
            run("pobi","1");
            assertThat(output()).contains("pobi : ", "최종 우승자 : pobi");
            }
        );
    }

    @Test
    void 시도_회수_입력값_타입에_대한_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_입력값이_0일_경우_예외_처리(){
        assertThatThrownBy(() -> runException("pobi,woni","0")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최종_우승자가_여러_명일_경우(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi,woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
