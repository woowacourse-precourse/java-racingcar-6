package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testSplitCarNames() {
        List<String> carNamesList = Application.splitCarNames("pobi,woni,BE");
        assertThat(carNamesList).containsExactly("pobi", "woni", "BE");
    }

    @Test
    void testCheckNamingError() {
        List<String> carNamesList = Arrays.asList("pobi", "woni", "javaji");
        assertThatThrownBy(() -> Application.checkNamingError(carNamesList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testConvertStringToInt_숫자일_때_int로_변환() {
        int numberOfRaces = Application.convertStringToInt("3");
        assertThat(numberOfRaces).isEqualTo(3);
    }

    @Test
    void testConvertStringToInt_숫자_아닐_때_예외_처리() {
        assertThatThrownBy(() -> Application.convertStringToInt("삼"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testGenerateAction() {
        int action = Application.generateAction();
        assertTrue(action == 0 || action == 1);
    }

    @Test
    void testRecordCarAction() {
        List<String> carNamesList = Arrays.asList("pobi", "woni", "javaji");
        List<Integer> carActionList = Application.recordCarAction(carNamesList);
        assertThat(carActionList).hasSameSizeAs(carNamesList);
        for (int element : carActionList) {
            assertTrue(element == 0 || element == 1);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}