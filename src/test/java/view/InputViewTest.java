package view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    void provideInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,lisa", "json,jiny"})
    @DisplayName("자동차 이름 입력 정상 동작하는지 테스트")
    void 이름_입력_테스트(String input) {
        //given
        List<String> expectedName = Arrays.asList(input.split(","));

        //when
        provideInput(input);
        List<String> result = InputView.getCarsNameFromUserInput();

        //then
        Assertions.assertThat(result).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("시도 횟수 입력 테스트")
    void 시도_횟수_입력_테스트(String input) {
        //given
        String exceptedInput = input;

        //when
        provideInput(input);
        String result = InputView.getAttemptsFromUserInput();

        //then
        Assertions.assertThat(result).isEqualTo(exceptedInput);
    }
}
