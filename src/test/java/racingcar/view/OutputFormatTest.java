package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.Output.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputFormatTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("결과 출력 포맷 테스트")
    void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {
        new OutputView().printResultFormat("pope","------");

        assertEquals("pope : ------", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    @DisplayName("우승자 출력 포맷 테스트")
    void print_winner() {
        new OutputView().printWinner("kiti");

        assertEquals("최종 우승자 : kiti",outputStreamCaptor.toString().trim());
    }
}
