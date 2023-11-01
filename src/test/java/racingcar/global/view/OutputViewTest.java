package racingcar.global.view;


import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.global.enums.OutputMessage.CAR_NAME_INPUT_MESSAGE;
import static racingcar.global.enums.OutputMessage.TRY_COUNT_INPUT_MESSAGE;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private OutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 자동차_이름_입력_요구_출력() {
        //given
        String expectedOutput = CAR_NAME_INPUT_MESSAGE.getMessage();

        //when
        OutputView.printCarNameInputMessage();
        String actualOutput = outputStream.toString();

        //then
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    void 시도_횟수_입력_요구_출력() {
        //given
        String expectedOutput = TRY_COUNT_INPUT_MESSAGE.getMessage();

        //when
        OutputView.printTryCountInputMessage();
        String actualOutput = outputStream.toString();

        //then
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

}