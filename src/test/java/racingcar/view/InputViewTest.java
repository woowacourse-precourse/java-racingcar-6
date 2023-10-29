package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"lion,cat,dog"})
    void readCarNamesTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] expectedResult = new String[]{"lion", "cat", "dog"};
        assertThat(InputView.readCarNames()).containsExactly(expectedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123"})
    void readRacingTryCountTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(InputView.readRacingTryCount()).isEqualTo(123);
    }
}