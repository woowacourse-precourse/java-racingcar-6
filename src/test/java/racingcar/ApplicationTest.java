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
    void split_메서드로_주어진_값을_구분() {
        String input = "pobi,woni,jun";
        String[] result = input.split(",");

        assertThat(result).contains("woni", "pobi", "jun");
        assertThat(result).containsExactly("pobi", "woni" , "jun");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "pobi";
        String[] result = input.split(",");

        assertThat(result).contains("pobi");
    }

    @Test
    void 입력값이_5글자를_넘지_않는지() {
        String[] carNames = {"pobi","woni","junho"};

        for (String carName : carNames) {
            assertThat(carName.length()).isLessThanOrEqualTo(5);
        }
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

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


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
