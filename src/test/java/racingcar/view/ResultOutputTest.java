package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class ResultOutputTest {
    private final ResultOutput output = new ResultOutput();

    @Test
    void 실행_결과_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        output.printAnnounce();

        assertThat(out.toString()).isEqualTo(String.format("%n%s%n", "실행 결과"));
    }

    @Test
    void 레이싱_과정_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String[] names = {"test"};
        String[] positions = {"--"};

        output.printRacing(names, positions);

        assertThat(out.toString()).isEqualTo(String.format("%s%n%n", "test : --"));
    }

    @Test
    void 우승자_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String winners = "test, win";

        output.printResult(winners);

        assertThat(out.toString()).isEqualTo(String.format("%s%n", "최종 우승자 : test, win"));
    }
}