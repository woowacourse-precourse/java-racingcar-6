package racingcar.view;

import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.common.Constants.ANNOUNCEMENT_OF_WINNER;
import static racingcar.common.Constants.NEW_LINE;
import static racingcar.common.Constants.RESULT_MESSAGE;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.IOTest;

class OutputViewTest extends IOTest {

    OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        systemOut();
    }

    @AfterEach
    void after() {
        clean();
    }

    @Test
    void showResultLog_메서드로_결과안내_문구_출력() {
        //given, when
        outputView.showResultLog();

        //then
        assertThat(getOutput()).contains(NEW_LINE, RESULT_MESSAGE);
    }

    @Test
    void showOneRound_메서드로_게임결과_출력() {
        //given
        HashMap<String, Integer> gameResult = new HashMap<>();
        gameResult.put("seori", 1);
        gameResult.put("snow", 0);
        gameResult.put("joy", 1);

        //when
        outputView.showOneRound(gameResult);
        String seoriResult = "seori : -";
        String snowResult = "snow : ";
        String joyResult = "joy : -";

        //then
        assertThat(getOutput()).contains(seoriResult, snowResult, joyResult);
    }

    @Test
    void showWinners_메서드로_최종우승자_출력_1명인_경우() {
        //given
        ArrayList<String> winners = new ArrayList<>();
        winners.add("seori");

        //when
        outputView.showWinners(winners);
        String result = format(ANNOUNCEMENT_OF_WINNER, "seori");

        //then
        assertThat(getOutput()).isEqualTo(result);
    }

    @Test
    void showWinners_메서드로_최종우승자_출력_2명_이상인_경우() {
        //given
        ArrayList<String> winners = new ArrayList<>();
        winners.add("seori");
        winners.add("snow");

        //when
        outputView.showWinners(winners);
        String result = format(ANNOUNCEMENT_OF_WINNER, "seori, snow");

        //then
        assertThat(getOutput()).isEqualTo(result);
    }

}