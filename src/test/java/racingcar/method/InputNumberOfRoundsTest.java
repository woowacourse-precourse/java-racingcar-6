package racingcar.method;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumberOfRoundsTest {

    @Test
    void 정상_입력시_정수반환() {
        Console.close();

        String testInput = "5";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        Assertions.assertThat(Application.inputNumberOfRounds()).isEqualTo(5);
    }

    @Test
    void 숫자1보다_작은값_입력시_예외반환() {
        String[] testInputList = {
                "0",
                "-1"
        };
        for (String testInput : testInputList) {
            numberOfMovesInputErrorOccurs(testInput);
        }
    }

    @Test
    void 숫자가_아닌값_입력시_예외반환() {
        String testInput = "d1f22";
        numberOfMovesInputErrorOccurs(testInput);
    }

    @Test
    void 정수범위_초과값_입력시_예외반환() {
        String testInput = "2147483648";
        numberOfMovesInputErrorOccurs(testInput);
    }

    private static void numberOfMovesInputErrorOccurs(String testInput) {
        Console.close();
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        assertThatThrownBy(Application::inputNumberOfRounds)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 2147483647 사이의 유효한 숫자를 입력해 주세요.");
    }
}