package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("이름 길이는 5자를 초과할 수 없다.")
    void validCarListInputTest(){
        //given
        String carListInput = "mercedes/avante";
        String trialNumberInput = "3";

        //when & then
        assertThatThrownBy(() -> Input.validateInput(carListInput, trialNumberInput))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("가장 많이 전진한 자동차가 승자이다.")
    void testFindWinners(){
        // given
        Game game = new Game();
        List<Car> gameState = new ArrayList<>();
        gameState.add(new Car("Jay", "----"));
        gameState.add(new Car("Jackson", "---"));
        gameState.add(new Car("Joly", "-------"));
        gameState.add(new Car("Jelly", "------"));

        // when
        String winners = game.findWinners(gameState);

        //then
        Assertions.assertEquals("Joly", winners);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
