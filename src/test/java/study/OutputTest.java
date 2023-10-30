package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class OutputTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void 한_라운드_결과_출력() {
        // given
        String name = "포비";
        int location = 3;

        // when
        OutputView.printPlayerRoundResult(name,location);
        String output = outContent.toString();

        // then
        Assertions.assertThat(output).contains("포비 : ---");
    }
}
