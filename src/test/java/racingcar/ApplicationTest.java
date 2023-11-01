package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    RacingManager racingManager = new RacingManager();

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
    void 전진_횟수_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 우승자_출력_2인상_테스트(){
        List<String> winnerString = new ArrayList<>();
        winnerString.add("pobi");
        winnerString.add("jun");
        String ANSWER = "최종 우승자 : pobi, jun";
        assertThat(racingManager.getWinnerString(winnerString)).isEqualTo(ANSWER);
    }

    @Test
    void 우승자_출력_1인_테스트(){
        List<String> winnerString = new ArrayList<>();
        winnerString.add("pobi");
        String ANSWER = "최종 우승자 : pobi";
        assertThat(racingManager.getWinnerString(winnerString)).isEqualTo(ANSWER);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
