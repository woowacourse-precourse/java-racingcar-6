package racingcar.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTeste {

    @ParameterizedTest
    @ValueSource(strings = {"Car A,car B", " Car A,car B "})
    void 자동차_이름_입력(String inputCarsName) {
        // given
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
        command(String.valueOf(inputMovesNumber));

        // when
        int movesNumber = InputView.enterMovesNumber();

        // then
        Assertions.assertAll(
                () -> assertThat(movesNumber).isEqualTo(inputMovesNumber)
        );
    }

    private void command(String input) {
        final byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}