package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.core.Core;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void stringToStringList_테스트() {
        // given
        final Core core = new Core();
        String case1 = "pobi,woni,jun";
        String case2 = "kim,lee,park";
        String case3 = "james,tom,sam";

        // when
        final List<String> result1 =  core.stringToStringList(case1);
        final List<String> result2 =  core.stringToStringList(case2);
        final List<String> result3 =  core.stringToStringList(case3);

        // then
        assertThat(result1).isEqualTo(List.of("pobi", "woni", "jun"));
        assertThat(result2).isEqualTo(List.of("kim", "lee", "park"));
        assertThat(result3).isEqualTo(List.of("james", "tom", "sam"));
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

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
