package study;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("사용자가 입력한 차 이름이 6자 이상의 이름인 경우 예외 발생")
    public void isCarNameWhenMoreThenSixThenException() {
        String input = "name,secondName";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.inputCarNames();
        });
    }

    @Test
    @DisplayName("사용자가 입력한 차 이름이 공백일 경우 예외 발생")
    public void isCarNameWhenBlankThenException() {
        String input = " ";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.inputCarNames();
        });
    }

    @Test
    @DisplayName("사용자가 입력한 차 이름에 쉼표(,)가 연속으로 나온 경우 예외 발생")
    public void isCarNameWhenDoubleCommasThenException() {
        String input = "a,,b";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.inputCarNames();
        });
    }

    @Test
    @DisplayName("사용자가 입력한 차 이름에 쉼표(,)가 처음에 나온 경우 예외 발생")
    public void isCarNameWhenStartCommasThenException() {
        String input = ",a,b";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.inputCarNames();
        });
    }

    @Test
    @DisplayName("사용자가 입력한 차 이름에 쉼표(,)가 마지막에 나온 경우 예외 발생")
    public void isCarNameWhenEndCommasThenException() {
        String input = "a,b,";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.inputCarNames();
        });
    }

    @Test
    @DisplayName("사용자가 입력한 차 이름에 중복된 이름을 입력할 경우 예외 발생")
    public void isCarNameWhenDuplicateThenException() {
        String input = "bb,bb";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.inputCarNames();
        });
    }

    @Test
    @DisplayName("사용자가 입력한 차 이름이 숫자가 들어온 경우 예외 발생")
    public void isCarNameWhenNumberThenException() {
        String input = "abc.";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.inputCarNames();
        });
    }

    @Test
    @DisplayName("사용자가 입력한 차 이름이 알파벳이나 쉼표(,)가 아닌 값 (공백도 불가능)일 경우 예외 발생")
    public void isCarNameWhenSpecialSymbolsThenException() {
        String input = "abc!,qwe";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.inputCarNames();
        });
    }

    @Test
    @DisplayName("사용자가 입력한 차 이름 중간에 공백이 들어간 경우 예외 발생")
    public void isCarNameWhenBlankBetweenThenException() {
        String input = "abc d,qwe";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.inputCarNames();
        });
    }

    @Test
    @DisplayName("사용자가 올바른 차 이름을 입력할 시, String 배열 반환")
    public void isCarNameWhenCurrectThenCarNameStrings() {
        String input = "pobi,zion";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        String[] result = Application.inputCarNames();

        assertThat(result).contains("pobi", "zion");
        assertThat(result).containsExactly("pobi", "zion");
    }


    @Test
    @DisplayName("사용자가 입력한 경주 횟수가 숫자가 아닌 경우 예외 발생")
    public void isRaceCountWhenNotaNumberThenException() {
        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.inputRaceCount();
        });
    }

    @Test
    @DisplayName("사용자가 입력한 경주 횟수가 공백일 경우 발생")
    public void isRaceCountWhenBlankThenException() {
        String input = " ";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.inputRaceCount();
        });
    }

    @Test
    @DisplayName("사용자가 입력한 경주 횟수가 숫자일 경우 String을 Integer로 변환한 값 반환")
    public void isRaceCountWhenNumberThenNumberInteger() {
        String input = "12";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        Integer result = Application.inputRaceCount();

        Assertions.assertEquals(result, 12);
    }
}
