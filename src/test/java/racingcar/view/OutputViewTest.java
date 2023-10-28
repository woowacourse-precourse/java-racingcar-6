package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    OutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setOut() {
        System.setOut(new PrintStream(out));
    }

    @DisplayName("실행 결과 문구를 성공적으로 출력한다.")
    @Test
    void printRacingResultMessage_Success() {
        // when
        OutputView.printRacingResultMessage();

        // then
        Assertions.assertThat(out.toString()).isEqualTo("실행 결과\n");
    }

    @DisplayName("실행 결과를 성공적으로 출력한다.")
    @Test
    void printRacingResult_Success() {
        // when
        OutputView.printRacingResult(List.of("pobi", "woni", "jun"), List.of(1, 2, 1));

        // then
        Assertions.assertThat(out.toString()).isEqualTo("pobi : -\nwoni : --\njun : -\n\n");
    }

    @DisplayName("우승자를 성공적으로 출력한다.")
    @Test
    void printWinners_Success() {
        // when
        OutputView.printWinners(List.of("pobi", "jun"));

        // then
        Assertions.assertThat(out.toString()).isEqualTo("최종 우승자 : pobi, jun\n");
    }
}
