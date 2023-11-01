package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.Controller;
import racingcar.model.Car;
import racingcar.view.InputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(() -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP);
    }

    @Test
    void ManyWinnersIfMaxTotalInputIsSame() {
        assertRandomNumberInRangeTest(() -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD);
    }

    @DisplayName("자동차 전진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void MoveCarIfRanNumOver4(int num) {
        // given
        final Car car = new Car();
        // when
        car.moveForward(num);
        // then
        assertThat(car.getTotalMove()).isEqualTo(1);
    }

    @DisplayName("자동차 정지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void StopCarIfRanNumLessThan3(int num) {
        // given
        final Car car = new Car();
        // when
        car.moveForward(num);
        // then
        assertThat(car.getTotalMove()).isEqualTo(0);
    }

    @DisplayName("자동차 이름이 5자 초과하거나 비어있으면 에러")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "@abcdef", "Abc12345", " "})
    void ThrowErrorIfCarNameLengthOver5orEmpty(String input) {
        System.setIn(generateUserInput(input));
        InputView inputView = new InputView();

        assertThatThrownBy(inputView::inputCarsName)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 하나만 입력되었을 경우 에러")
    @ParameterizedTest
    @ValueSource(strings = {"1", "@abcf", "Abc"})
    void ThrowErrorIfCarNameExistOne(String input) {
        System.setIn(generateUserInput(input));
        InputView inputView = new InputView();

        assertThatThrownBy(inputView::inputCarsName)
                .isInstanceOf(IllegalArgumentException.class);
    }

    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> assertThatThrownBy(
                () -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
