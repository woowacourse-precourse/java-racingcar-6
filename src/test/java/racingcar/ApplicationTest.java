package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    
    private InputImpl inputImpl = new InputImpl();

    @Test
    void carNameTest() {
        run("car1,car2,car3");
        List<String> carNames = inputImpl.carName();
        assertSimpleTest(() -> assertThat(carNames).isEqualTo(Arrays.asList("car1", "car2", "car3")));
    }

    @Test
    void attemptsNumberTest() {
        run("5");
        int attemptsNumber = inputImpl.attemptsNumber();
        assertSimpleTest(() -> assertThat(attemptsNumber).isEqualTo(5));
    }

    @Test
    void invalidAttemptsNumberTest() {
        run("0");
        assertSimpleTest(() -> assertThatThrownBy(inputImpl::attemptsNumber)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("시도 횟수는 0이상이어야 합니다."));
    }

    @Test
    void invalidCarNameLengthTest() {
        run("car123456");
        assertSimpleTest(() -> assertThatThrownBy(inputImpl::carName)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름은 5자 이하만 가능합니다."));
    }

    @Test
    void invalidCarNameCountTest() {
        run("car1");
        assertSimpleTest(() -> assertThatThrownBy(inputImpl::carName)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 2개 이상이어야 합니다."));
    }

    @Test
    void carNameWithTrailingSpaceTest() {
        run("car1, ");
        assertSimpleTest(() -> assertThatThrownBy(inputImpl::carName)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름 뒤에 공백이 올 수 없습니다."));
    }
    
    @Test
    void carMoveTest() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        GameItemImpl gameItem = new GameItemImpl(carNames);
        assertSimpleTest(() -> {
            gameItem.carMove(5, new OutputImpl(carNames, gameItem.carPosition()));
            assertThat(gameItem.carPosition().get("car1")).isBetween(0, 5);
            assertThat(gameItem.carPosition().get("car2")).isBetween(0, 5);
            assertThat(gameItem.carPosition().get("car3")).isBetween(0, 5);
        });
    }

    @Test
    void checkWinnerTest() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        GameItemImpl gameItem = new GameItemImpl(carNames);
        assertSimpleTest(() -> {
            gameItem.carMove(5, new OutputImpl(carNames, gameItem.carPosition()));
            List<String> winners = gameItem.checkWinner();
            assertThat(winners).isNotEmpty();
            for (String winner : winners) {
                assertThat(winner).isIn(carNames);
            }
        });
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
