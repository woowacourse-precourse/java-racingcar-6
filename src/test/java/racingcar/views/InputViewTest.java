package racingcar.views;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameIncorrectException;

class InputViewTest {

    @Test
    @DisplayName("Console readLine 테스트")
    void consoleREadLineTest() {
        String input = "입력 값 테스트";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = Console.readLine();

        assertThat(result).isEqualTo(input);
    }

    @Test
    @DisplayName("자동차 이름 입력 시 빈값, null 입력 시 예외 발생")
    void nullAndEmptyCheckTest() {

        String inputNull = null;
        String inputEmpty = "";
        String inputBlank = "  ";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.checkNullAndEmpty(inputNull);
        });
        Assertions.assertThrows(CarNameIncorrectException.class, () -> {
            InputView.checkNullAndEmpty(inputNull);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.checkNullAndEmpty(inputEmpty);
        });
        Assertions.assertThrows(CarNameIncorrectException.class, () -> {
            InputView.checkNullAndEmpty(inputEmpty);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.checkNullAndEmpty(inputBlank);
        });
        Assertions.assertThrows(CarNameIncorrectException.class, () -> {
            InputView.checkNullAndEmpty(inputBlank);
        });

    }

}