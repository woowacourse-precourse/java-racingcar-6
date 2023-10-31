package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    OutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void endPreviousGame() {
        Console.close();
    }

    @Test
    void 이름_공백_제거_확인() {
        String input = inputFormat("car1               , ca   r2, c a r 3", "1");
        handleInput(input);
        initiateOutput();
        run();
        String outPut = returnOutput();
        assertThat(outPut).contains("car1", "car2", "car3");
    }

    @Test
    void 차_이름_입력_확인() {
        String input = inputFormat("cream,bread,yummy", "1");
        handleInput(input);
        initiateOutput();
        run();
        String output = returnOutput();
        assertThat(output).contains("cream", "bread", "yummy");
    }

    @Test
    void 숫자가_아닌_횟수_예외처리() {
        String input = inputFormat("wooa,tech", "a");
        handleInput(input);
        assertThatThrownBy(() -> run())
                .isInstanceOf(IllegalArgumentException.class);

    }

    String inputFormat(String carNames, String stageTimes) {
        return String.join("\n", carNames, stageTimes);
    }

    void run() {
        Application.main(new String[]{});
    }

    void handleInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    void initiateOutput() {
        System.setOut(new PrintStream(out));
    }

    String returnOutput() {
        return out.toString().trim();
    }
}
