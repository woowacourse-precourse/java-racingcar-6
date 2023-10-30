package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MethodsTest {

    @Test
    void splitCarNamesTest() {
        List<String> carNamesList = Application.splitCarNames("pobi,woni,BE");
        assertThat(carNamesList).containsExactly("pobi", "woni", "BE");
    }

    @Test
    void checkNamingErrorTest() {
        List<String> carNamesList = Arrays.asList("pobi", "woni", "javaji");
        assertThatThrownBy(() -> Application.checkNamingError(carNamesList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void convertStringToIntTest_숫자일_때_int로_변환() {
        int numberOfRaces = Application.convertStringToInt("3");
        assertThat(numberOfRaces).isEqualTo(3);
    }

    @Test
    void convertStringToIntTest_숫자_아닐_때_예외_처리() {
        assertThatThrownBy(() -> Application.convertStringToInt("삼"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateActionTest() {
        int action = Application.generateAction();
        assertTrue(action == 0 || action == 1);
    }

    @Test
    void recordCarActionTest() {
        List<String> carNamesList = Arrays.asList("pobi", "woni", "javaji");
        List<Integer> carActionList = Application.recordCarAction(carNamesList);
        assertThat(carActionList).hasSameSizeAs(carNamesList);
        for (int element : carActionList) {
            assertTrue(element == 0 || element == 1);
        }
    }

    @Test
    void printCarRaceTest() {
    }

    @Test
    void extractWinnerIndexTest() {
        List<Integer> winnerIndexList =
                Application.extractWinnerIndex(Arrays.asList(1, 4, 2, 4));
        assertThat(winnerIndexList).containsExactly(1, 3);
    }

    @Test
    void decideWinnerTest() {
        List<String> winnerNameList = Application.decideWinner(
                Arrays.asList(1, 4, 2, 4), Arrays.asList("pobi", "woni", "BE", "kiki")
        );
        assertThat(winnerNameList).containsExactly("woni", "kiki");
    }

    @Test
    void printWinnerTest() {
    }
}