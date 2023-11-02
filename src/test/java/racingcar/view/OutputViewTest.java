package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

public class OutputViewTest {

    private OutputView outputView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        outputView = new OutputView();
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @DisplayName("printInputRacingCarNames()은 올바른 문구를 출력한다. - 성공")
    @Test
    public void testPrintInputRacingCarNames() {
        // when
        outputView.printInputRacingCarNames();

        // then
        assertThat(outContent.toString()).hasToString("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    @DisplayName("printRunResult()은 올바른 문구를 출력한다. - 성공")
    @Test
    public void testPrintRunResult() {
        // when
        outputView.printRunResult();

        // then
        assertThat(outContent.toString()).hasToString("\n실행 결과\n");
    }

    @DisplayName("printNewLine()은 줄바꿈을 실행한다. - 성공")
    @Test
    public void testPrintNewLine() {
        // when
        outputView.printNewLine();

        // then
        assertThat(outContent.toString()).hasToString("\n");
    }

    @DisplayName("printInputTotalAttempts()은 올바른 문구를 출력한다 - 성공")
    @Test
    public void testPrintInputTotalAttempts() {
        // when
        outputView.printInputTotalAttempts();

        // then
        assertThat(outContent.toString()).hasToString("시도할 회수는 몇회인가요?\n");
    }

    @DisplayName("printGameProgress()은 올바른 문구를 출력한다 - 성공")
    @Test
    public void testPrintGameProgress() {
        //given
        List<RacingCar> racingCarList = Arrays.asList(
            new RacingCar("pobi"),
            new RacingCar("woni")
        );

        // when
        outputView.printGameProgress(racingCarList);

        // then
        assertThat(outContent.toString()).hasToString("pobi : \nwoni : \n\n");
    }

    @DisplayName("승리자가 1명인 경우 printWinners()는 올바른 문구를 출력한다 - 성공")
    @Test
    public void testPrintWinnersIfOne() {
        // given
        List<String> winner = List.of("a");

        // when
        outputView.printWinners(winner);

        // then
        assertThat(outContent.toString()).hasToString("최종 우승자 : a\n");
    }

    @DisplayName("승리자가 1명 이상인 경우 printWinners()는 올바른 문구를 출력한다 - 성공")
    @Test
    public void testPrintWinnersIfMoreThanOne() {
        // given
        List<String> winner = Arrays.asList("a", "b");

        // when
        outputView.printWinners(winner);

        // then
        assertThat(outContent.toString()).hasToString("최종 우승자 : a, b\n");
    }


}
