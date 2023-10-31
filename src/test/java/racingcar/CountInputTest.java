package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Computer.getInput;
import static racingcar.Error.NOT_NUMBER_ERROR;
import static racingcar.Error.ROUND_COUNT_ERROR;
import static racingcar.Message.INPUT_RACING_ROUND;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CountInputTest {

    @Test
    void 음수_또는_0_입력_시_예외_처리() {

        // given
        String userInputOne = "-1";
        String userInputTwo = "0";

        // when, then
        assertThatThrownBy(() -> Validator.checkNumber(userInputOne))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ROUND_COUNT_ERROR.getMessage());

        assertThatThrownBy(() -> Validator.checkNumber(userInputTwo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ROUND_COUNT_ERROR.getMessage());
    }

    @Test
    void 문자_또는_공백_입력_시_예외_처리() {

        // given
        String userInputOne = "3pobi";
        String userInputTwo = " ";

        // when, then
        assertThatThrownBy(() -> Validator.checkNumber(userInputOne))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER_ERROR.getMessage());

        assertThatThrownBy(() -> Validator.checkNumber(userInputTwo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER_ERROR.getMessage());
    }

    @Test
    void 시도_횟수_출력문() {

        // given
        Car car = new Car(Arrays.asList("pobi", "woni", "jun"));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        car.move(CarRace.createRound(getInput(INPUT_RACING_ROUND.getMessage())));

        // then
        assertThat(out.toString())
                .contains(INPUT_RACING_ROUND.getMessage());

        Console.close();
    }
}
