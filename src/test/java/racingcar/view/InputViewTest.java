package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {

    InputView inputView = new InputView();

    private void setSystemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @AfterEach
    void tearDown() {
        inputView.close();
    }

    @DisplayName("이름 입력 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "park:1:park",
            "kim,lee,park:3:kim",
            " left,right , all :3: left"}, delimiter = ':', ignoreLeadingAndTrailingWhitespace = false)
    void readCarNames(String names, int size, String first) {

        setSystemIn(names);

        List<String> carNames = inputView.readCarNames();

        Assertions.assertThat(carNames.size()).isEqualTo(size);
        Assertions.assertThat(carNames.get(0)).isEqualTo(first);

    }

    @DisplayName("횟수 입력 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10,10", "-1,-1"})
    void readNumRound(String input, int result) {

        setSystemIn(input);

        int numRound = inputView.readNumRound();

        Assertions.assertThat(numRound).isEqualTo(result);

    }

    @DisplayName("정수 범위를 벗어난 횟수 입력")
    @Test
    void readNumRoundOverInteger() {

        String wrongInput = Integer.toString(Integer.MAX_VALUE) + "0";
        setSystemIn(wrongInput);

        assertThrows(IllegalArgumentException.class, () -> inputView.readNumRound());

    }

}