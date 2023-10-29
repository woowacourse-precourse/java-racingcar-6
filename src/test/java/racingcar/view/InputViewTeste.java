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
    void 자동차_이름_입력(String carsName) {
        // given
        command(carsName);

        // when
        List<String> inputCarsName = InputView.enterCarsName();

        // then
        Assertions.assertAll(
                () -> assertThat(inputCarsName).isNotNull(),
                () -> assertThat(inputCarsName).hasSize(2),
                () -> assertThat(inputCarsName.get(0)).isNotEmpty()
        );
    }

    private void command(String input) {
        final byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}