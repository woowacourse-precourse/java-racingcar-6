package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Checker;
import racingcar.domain.Game;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    void test_makeMembers() {// 정상
        String input = "pobi,woni";
        Game game = new Game();
        game.makeMembers(input);
    }

    @Test
    void test_makeMembers2() {
        String input = "pobi,,woni";
        Game game = new Game();

        assertThatThrownBy(() -> game.makeMembers(input))
                .hasMessageContaining("잘못된 값 입력");
    }

    @Test
    void test_makeMembers3() {
        String input = "pobi, ,woni";
        Game game = new Game();

        assertThatThrownBy(() -> game.makeMembers(input))
                .hasMessageContaining("잘못된 값 입력");
    }

    @Test
    void test_makeAttempts(){
        String input = "3";
        Game game = new Game();
        game.makeAttempts(input);
    }

    @Test
    void test_makeAttempts2(){
        String input = "a";
        Game game = new Game();
        assertThatThrownBy(() -> game.makeAttempts(input))
                .hasMessageContaining("잘못된 값 입력");
    }
    @Test
    void test_makeAttempts3(){
        String input = "";
        Game game = new Game();
        assertThatThrownBy(() -> game.makeAttempts(input))
                .hasMessageContaining("잘못된 값 입력");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
