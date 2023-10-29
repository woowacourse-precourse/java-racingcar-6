package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.domain.EachMoveResultDto;
import racingcar.domain.GameWinnerDto;
import racingcar.view.OutputView;

public class OutputViewTest {

    private static ByteArrayOutputStream outputStream;
    OutputView outputView = OutputView.getInstance();

    @BeforeAll
    public static void setStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void displayGameWinner() {
        String result = "최종 우승자 : " + "pobi" + System.lineSeparator();
        List<GameWinnerDto> gameWinnerDtos = Arrays.asList(new GameWinnerDto("pobi"));
        outputView.displayGameWinner(gameWinnerDtos);
        assertThat(outputStream.toString()).isEqualTo(result);
    }

    @Test
    void displayGameResult() {
        String result = "실행 결과" + System.lineSeparator();
        outputView.displayGameResult();
        assertThat(outputStream.toString()).isEqualTo(result);
    }

    @Test
    void displayEachGameResult() {
        String result = "pobi : -" + System.lineSeparator().repeat(2);
        List<EachMoveResultDto> eachMoveResultDtos = Arrays.asList(new EachMoveResultDto("pobi", 1));
        outputView.displayEachGameResult(eachMoveResultDtos);
        assertThat(outputStream.toString()).isEqualTo(result);
    }

}
