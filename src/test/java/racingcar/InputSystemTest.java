package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Utils.InputSystem;

class InputSystemTest {

    public InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @DisplayName("입력 받은 자동차 이름 ','기준으로 나눠서 배열에 저장")
    @Test
    void inputCarsTest() {
        InputStream userInput = setReadLine("pobi,woni");
        System.setIn(userInput);

        String expect = "[pobi, woni]";
        String[] actual = InputSystem.inputCars();

        assertThat(Arrays.toString(actual)).isEqualTo(expect);
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10, 15})
    @DisplayName("횟수 0이상의 정수 입력 확인")
    void inputRaceCountIsIntegerOverZero(int num) {
        InputStream userInput = setReadLine(String.valueOf(num));
        System.setIn(userInput);

        int actual = InputSystem.inputRaceCount();

        assertThat(actual).isGreaterThan(0);
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -5, -15, -23})
    @DisplayName("횟수 0이하의 정수 입력 시 예외 발생")
    void inputRaceCountIsNotIntegerDownZero() {
        InputStream userInput = setReadLine("0");
        System.setIn(userInput);

        assertThatThrownBy(() -> InputSystem.inputRaceCount()).isInstanceOf(IllegalArgumentException.class);
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", " "})
    @DisplayName("횟수 정수 제외 입력 시 예외 발생")
    void inputRaceCountIsNotInteger(String text) {
        InputStream userInput = setReadLine(text);
        System.setIn(userInput);

        assertThatThrownBy(() -> InputSystem.inputRaceCount()).isInstanceOf(IllegalArgumentException.class);
        Console.close();
    }
}