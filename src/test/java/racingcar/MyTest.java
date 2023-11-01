package racingcar;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;



public class MyTest extends NsTest {

    @Test
    void 한사람만_입력되었을_때() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "4");
                    assertThat(output()).contains("pobi : ", "최종 우승자 : pobi");
                },
                9
        );
    }

    @Test
    void 한번도_시도_안했을_떄() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "0");
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                1,1
        );
    }
    @Test
    void 아무도_전진하지_않을_때() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                1,1
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
