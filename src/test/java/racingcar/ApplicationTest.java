package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Map;
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

    // InputView class tests
    @Test
    void 입력한_자동차_이름_배열로_변환() {
        String input = "pobi,woni";
        String[] result = InputView.makeInputArray(input);

        assertThat(result).containsExactly("pobi", "woni");
    }

    @Test
    void 입력한_자동차_이름_올바른_구분자가_없을_경우_예외_발생() {
        String input = "pobi-woni";

        assertThatThrownBy(() -> InputView.validDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_길이가_5보다_클_경우_예외_발생() {
        String[] input = {"javagi"};

        assertThatThrownBy(() -> InputView.validInputLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_문자열이_0이하일_경우_예외_발생() {
        String input = "0";

        assertThatThrownBy(() -> InputView.validNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_문자열이_올바르지_않을_경우_예외_발생() {
        String input = "notNumber";

        assertThatThrownBy(() -> InputView.validNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // Racing class tests
    @Test
    void 자동차_이름으로_기록지_생성_확인() {
        String[] cars = {"pobi", "woni"};
        Map<String, Integer> record = Racing.makeRecord(cars);

        assertThat(record.get("pobi")).isEqualTo(0);
        assertThat(record.get("woni")).isEqualTo(0);
    }

    @Test
    void 승자_결정_확인() {
        Map<String, Integer> record = Map.of("pobi", 5, "woni", 3);
        String[] winners = Racing.decideWinner(record);

        assertThat(winners).containsExactly("pobi");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
