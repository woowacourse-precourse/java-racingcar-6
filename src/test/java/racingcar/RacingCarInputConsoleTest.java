package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.console.RacingCarConsole;

public class RacingCarInputConsoleTest {
    private static RacingCarConsole racingCarConsole;

    @BeforeEach
    void openRacingCarConsole() {
        racingCarConsole = new RacingCarConsole();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 자동차_이름_입력받기_예외처리() {
        assertThatThrownBy(() -> {
                    String input = "";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));
                    racingCarConsole.readCarNames();
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름을 정해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", "홍길동,test,a맨\n"})
    void 자동차_이름_입력받기_개행_예외_발생하지_않음(String input) {
        assertThatCode(() -> {
                    System.setIn(new ByteArrayInputStream(input.getBytes()));
                    racingCarConsole.readCarNames();
                })
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3\n", "0\n", "-12\n"})
    void 시도_회수_입력받기_양수_입력_정상처리(String input) {
        assertThatCode(() -> {
                    System.setIn(new ByteArrayInputStream(input.getBytes()));
                    racingCarConsole.readIterationNumBer();
                })
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc\n", "11a\n", "11!\n", "11abc!\n"})
    void 시도_회수_입력받기_문자열_입력_예외처리(String input) {
        assertThatCode(() -> {
                    System.setIn(new ByteArrayInputStream(input.getBytes()));
                    racingCarConsole.readIterationNumBer();
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 회수는 숫자로 입력해주세요.");
    }
}
