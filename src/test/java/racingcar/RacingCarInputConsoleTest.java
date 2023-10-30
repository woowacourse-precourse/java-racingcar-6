package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    void 자동차_이름_입력받기_빈문자열_예외처리() {
        assertThatThrownBy(() -> {
                    String input = "";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));
                    racingCarConsole.readCarNames();
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름을 정해주세요.");
    }

    @Test
    void 자동차_이름_입력받기_개행_예외_발생하지_않음() {
        assertThatCode(() -> {
                    String input = "\n";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));
                    racingCarConsole.readCarNames();
                })
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름_입력받기_정상_처리() {
        assertThatCode(() -> {
                    String input = "홍길동,test,a맨\n";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));
                    racingCarConsole.readCarNames();
                })
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_회수_입력받기_양수_입력_정상처리() {
        assertThatCode(() -> {
                    String input = "3\n";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));
                    racingCarConsole.readIterationNumBer();
                })
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_회수_입력받기_0_입력_정상처리() {
        assertThatCode(() -> {
                    String input = "0\n";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));
                    racingCarConsole.readIterationNumBer();
                })
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_회수_입력받기_음수_입력_정상처리() {
        assertThatCode(() -> {
                    String input = "-12\n";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));
                    racingCarConsole.readIterationNumBer();
                })
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_회수_입력받기_문자열_입력_예외처리() {
        assertThatCode(() -> {
                    String input = "11abc!\n";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));
                    racingCarConsole.readIterationNumBer();
                })
                .doesNotThrowAnyException();
    }
}
