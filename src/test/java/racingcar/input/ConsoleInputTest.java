package racingcar.input;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleInputTest {

    private final Input input = new ConsoleInput();

    @DisplayName("경주할 자동차 이름들을 입력받는다.")
    @Test
    void inputRacingCarNames() {
        //given
        String carNameA = "A";
        String carNameB = "B";
        String carNameC = "C";
        String racingCarNamesInput = carNameA + ", "  + carNameB + ", " + carNameC;
        InputStream in = new ByteArrayInputStream(racingCarNamesInput.getBytes());
        System.setIn(in);

        //when
        List<String> racingCarNames = input.inputRacingCarNames();

        //then
        assertThat(racingCarNames).hasSize(3)
                .contains(carNameA, carNameB, carNameC);
    }

    @DisplayName("경주할 자동차 이름은 5자를 초과할 경우 예외가 발생한다.")
    @Test
    void inputRacingCarNameOver5Characters() {
        //given
        String carNameA = "ABCDEFG";
        InputStream in = new ByteArrayInputStream(carNameA.getBytes());
        System.setIn(in);

        //when //then
        assertThatThrownBy(input::inputRacingCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

}
