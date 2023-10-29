package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"Car A,car B", " Car A,car B "})
    void 자동차_이름_입력(String inputCarsName) {
        // given
        Console.close();
        command(inputCarsName);

        // when
        List<String> carsName = InputView.enterCarsName();

        // then
        Assertions.assertAll(
                () -> assertThat(carsName).isNotNull(),
                () -> assertThat(carsName).hasSize(2),
                () -> assertThat(carsName.get(0)).isNotEmpty(),
                () -> assertThat(carsName.get(0)).isEqualTo(inputCarsName.split(",")[0].trim())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10})
    void 이동_횟수_입력(int inputMovesNumber) {
        // given
        Console.close();
        command(String.valueOf(inputMovesNumber));

        // when
        int movesNumber = InputView.enterMovesNumber();

        // then
        Assertions.assertAll(
                () -> assertThat(movesNumber).isEqualTo(inputMovesNumber)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "CHARACTER", "**"})
    void 이동_횟수_숫자_검증(String inputMovesNumber) {
        // given
        Console.close();
        command(inputMovesNumber);

        // when & then
        assertThatThrownBy(InputView::enterMovesNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다.");
    }

    private void command(String input) {
        final byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}