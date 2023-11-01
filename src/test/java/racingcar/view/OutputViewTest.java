package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.ScoreDto;
import racingcar.service.ScoreBoardService;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("스코어를 잘 출력하는지 확인")
    void DisplayScoreBoard() {
        ScoreDto pobiScoreDto = new ScoreDto("pobi", 3);
        ScoreDto dobiScoreDto = new ScoreDto("dobi", 5);
        List<ScoreDto> scoreBoard = new ArrayList<>();
        scoreBoard.add(pobiScoreDto);
        scoreBoard.add(dobiScoreDto);
        ScoreBoardService scoreBoardService = new ScoreBoardService();
        scoreBoardService.recordRound(1, scoreBoard);

        OutputView.displayScoreBoard(scoreBoardService.getScoreBoard());
        String expectedOutput = "pobi : ---\ndobi : -----\n\n";

        assertThat(output.toString()).isEqualTo(expectedOutput);
    }

}
