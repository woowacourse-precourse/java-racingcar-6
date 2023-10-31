package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Constants;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 게임_결과_메세지_출력() {
        String expectedOutput = Constants.OUTPUT_GAME_RESULT;
        OutputView.printGameResult();

        assertThat(output.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void 최종_우승자_출력() {
        String winner = "pobi, jun";
        OutputView.printGameWinner(winner);

        assertThat(output.toString()).isEqualTo(Constants.OUTPUT_GAME_WINNER, winner);
    }

    @Test
    void 자동차_이름_출력() {
        String carName = "pobi";
        OutputView.printCarName(carName);

        assertThat(output.toString()).isEqualTo(Constants.OUTPUT_CAR_NAME, carName);
    }

    @Test
    void 하이픈_출력() {
        OutputView.printHyphen();

        assertThat(output.toString()).isEqualTo(Constants.OUTPUT_HYPHEN);
    }

    @Test
    void 공백줄_출력() {
        OutputView.printBlankLine();

        assertThat(output.toString()).isEqualTo(Constants.OUTPUT_BLANK_LINE);
    }

    @Test
    void 자동차_이름들_입력_메세지_출력() {
        OutputView.printInputCarNames();

        assertThat(output.toString()).isEqualTo(Constants.INPUT_CAR_NAMES);
    }

    @Test
    void 이동_횟수_입력_메세지_출력() {
        OutputView.printInputNumber();

        assertThat(output.toString()).isEqualTo(Constants.INPUT_NUMBER);
    }
}