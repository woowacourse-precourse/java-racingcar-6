package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


public class GameTest extends NsTest {

    @Test
    void 게임_진행_출력_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "4");
                assertThat(output()).contains("pobi : ---", "woni : -");
            }, 5, 1, 5, 1, 3, 7, 8, 2
        );
    }

    @Test
    void 플레이어_2인_단독_우승_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "2");
                assertThat(output()).contains("pobi : --", "woni : ", "최종 우승자 : pobi");
            }, 5, 1, 5, 1
        );
    }

    @Test
    void 플레이어_2인_공동_우승_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "2");
                assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni");
            }, 5, 6, 5, 6
        );
    }

    @Test
    void 플레이어_3인_단독_우승_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            }, 5, 1, 1
        );
    }

    @Test
    void 플레이어_3인_공동_우승_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "1");
                assertThat(output()).contains("pobi : -", "woni : -", "jun : ",
                    "최종 우승자 : pobi, woni");
            }, 5, 6, 1
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
