package car;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ImplTest extends NsTest {

    @Test
    void 전체기능_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c", "3");
                    assertThat(output()).contains("a : -", "b : -","c : ",
                            "a : --", "b : --","c : ",
                            "a : ---", "b : ---","c : -","최종 우승자 : a, b");
                },
                4,4,3,4,4,2,4,4,4
        );
    }

    @Test
    void 회수가_0일때() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c", "0");
                    assertThat(output()).contains("최종 우승자 : a, b, c");
                },
                -1,-1,-1
        );
    }

    @Test
    void 음수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,a", "-11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 회수가_0으로_시작할_때_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,a", "01"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    protected void runMain() { Application.main(new String[]{}); }
}
