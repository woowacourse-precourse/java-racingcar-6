package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MethodsTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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
    void playCarRaceTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Integer> result = Application.playCarRace(
                            2, Arrays.asList("pobi", "woni", "BE")
                    );
                    assertThat(result).isEqualTo(Arrays.asList(1, 0, 2));
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void recordCarActionTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Integer> recordStorage = Application.recordCarAction(
                            Arrays.asList("pobi", "woni", "BE"), Arrays.asList(0, 0, 0)
                    );
                    assertThat(recordStorage).isEqualTo(Arrays.asList(1, 0, 1));
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void generateActionTest_난수_4이상_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 4; i < 10; i++) {
                        int action = Application.generateAction();
                        assertThat(action).isEqualTo(1);
                    }
                },
                4, 5, 6, 7, 8, 9
        );
    }

    @Test
    void generateActionTest_난수_4미만_멈춤() {
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 4; i++) {
                        int action = Application.generateAction();
                        assertThat(action).isEqualTo(0);
                    }
                },
                0, 1, 2, 3
        );
    }

    @Test
    void printCarRaceTest() {
        assertSimpleTest(
                () -> {
                    Application.printCarRace(Arrays.asList("pobi", "woni"), Arrays.asList(3, 4));
                    assertThat(output()).contains("pobi : ---", "woni : ----");
                }
        );
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
    void printWinnerTest_단독_우승자() {
        assertSimpleTest(
                () -> {
                    Application.printWinner(Arrays.asList("woni"));
                    assertThat(output()).isEqualTo("최종 우승자 : woni");
                }
        );
    }

    @Test
    void printWinnerTest_공동_우승자() {
        assertSimpleTest(
                () -> {
                    Application.printWinner(Arrays.asList("woni", "kiki"));
                    assertThat(output()).isEqualTo("최종 우승자 : woni, kiki");
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
