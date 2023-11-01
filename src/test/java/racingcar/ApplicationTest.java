package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;
import racingcar.domain.Validate;

import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final List<String> ANSWER = Arrays.asList("sam", "smith");
    private static final int MAX_SCORE = 8;

    public static Map<String, Integer> racers() {
        Map<String, Integer> racers = new LinkedHashMap<>();
        racers.put("sam", 5);
        racers.put("smith", 8);
        return racers;
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
    @Test
    void 최종_결과_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains("pobi : -----", "woni : -----", "jun : ---", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
                ,STOP,MOVING_FORWARD
        );
    }
    @Test
    void 이름에_대한_입력값_예외_확인() {
        String input = "bestpobi";
        String message = "이름은 5자리 이하만 가능합니다.";
        assertThatThrownBy(() -> Validate.NameLengthLimit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);

    }

    @Test
    void 자동차_이름값_성공_확인() {

        List<String> ExpectedNames = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : racers().entrySet()) {
            ExpectedNames.add(entry.getKey());
        }
        assertThat(ANSWER).isEqualTo(ExpectedNames);
    }

    @Test
    void 가장_많이_이동한_횟수_출력() {

        Game game = new Game();
        int maxScore = game.topScore(racers());
        assertThat(MAX_SCORE).isEqualTo(maxScore);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
