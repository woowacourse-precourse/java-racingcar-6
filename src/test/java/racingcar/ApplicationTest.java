package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.utils.constant.Message;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    Game game = new Game();
    Car car;


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


    // 추가한 테스트 케이스
    @Test
    void 자동차_이름을_하나만_입력했을_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("mycar"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름의_길이가_5글자를_넘을_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("mysupercar", "mycar"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Message.MAX_CAR_NAME_ERROR)
        );
    }

    @Test
    void 자동차_이름사이에_공백이_있을_경우_잘_저장되는지() {
        String[] inputArr = {"  ab c ", "   ef g   ", " car  "};
        List<Car> cars = game.saveCarNames(inputArr);

        assertThat(cars.get(0).getName()).isEqualTo("ab c");
        assertThat(cars.get(1).getName()).isEqualTo("ef g");
        assertThat(cars.get(2).getName()).isEqualTo("car");

    }

    @Test
    void 게임_반복_횟수를_0_이하_또는_정수가_아닌수를_입력할때_예외_발생() {
        String input1 = "a";
        String input2 = "-2";

        assertThatThrownBy(() -> game.repeatNumberExceptionCheck(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.MIN_REPEAT_ERROR);

        assertThatThrownBy(() -> game.repeatNumberExceptionCheck(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.MIN_REPEAT_ERROR);

    }


}
