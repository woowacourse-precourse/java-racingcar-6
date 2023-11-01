package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingResultDTO;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OutputViewTest {

    private OutputView outputView;
    private OutputStream outputStream;

    @BeforeEach
    void setMockOutput() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputView = new OutputView();
    }

    @AfterEach
    void setSystemOut() {
        System.setOut(System.out);
    }

    @Test
    void 최종_우승자_출력() {
        List<String> winners = List.of("matia", "maria");
        outputView.printWinners(winners);

        assertThat(outputStream.toString()).contains("최종 우승자 : matia, maria");
    }

    @Test
    void 실행결과_메시지_출력() {
        outputView.printResultMessage();

        assertThat(outputStream.toString()).contains("실행 결과");
    }

    @Test
    void 경주_결과_출력() {
        var names = List.of("matia", "maria");
        var positions = List.of(0, 5);
        RacingResultDTO racingResultDTO = new RacingResultDTO(names, positions);
        outputView.printRacingResult(racingResultDTO);

        assertThat(outputStream.toString()).contains("matia : ", "maria : -----");
    }
}