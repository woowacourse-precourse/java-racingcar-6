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

    private static int[] MOVING_FORWARD_NUMS = {4,5,6,7,8,9};
    private static int[] STOP_NUMS = {0,1,2,3};

    @Test
    void 숫자가_4이상이면_전진하고_3이하면_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("dori,woni", "6");
                assertThat(output()).contains("dori : ------", "woni : ");
            },
            MOVING_FORWARD_NUMS[0], STOP_NUMS[0],
            MOVING_FORWARD_NUMS[1], STOP_NUMS[1],
            MOVING_FORWARD_NUMS[2], STOP_NUMS[2],
            MOVING_FORWARD_NUMS[3], STOP_NUMS[3],
            MOVING_FORWARD_NUMS[4], STOP_NUMS[3],
            MOVING_FORWARD_NUMS[5], STOP_NUMS[3]
        );
    }
    @Test
    void 우승자가_2명인_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,dori", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "dori : " , "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }
    @Test
    void 우승자가_없는_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,dori", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "dori : " , "우승자가 없습니다.");
                },
                STOP, STOP, STOP
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
    void 경주횟수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0", "횟수가 아닌 값", "1이상"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}