package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Score;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameViewTest {

    @DisplayName("모든 레이스 결과를 출력하는 테스트")
    @Test
    void raceResultView() {
        //when
        RacingGameView racingGameView = new RacingGameView();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));


        //given

        List<Score> oneRound = List.of(new Score("pobi", 1), new Score("suhw", 0));
        List<Score> twoRound = List.of(new Score("pobi", 1), new Score("suhw", 1));
        List<Score> threeRound = List.of(new Score("pobi", 2), new Score("suhw", 2));
        List<Score> fourRound = List.of(new Score("pobi", 2), new Score("suhw", 3));

        List<List<Score>> result = List.of(oneRound, twoRound, threeRound, fourRound);
        racingGameView.raceResults(result);
        String expectedResult = "\n" +
                "실행 결과\n" +
                "pobi : -\n" +
                "suhw : \n" +
                "\n" +
                "pobi : -\n"
                + "suhw : -\n" +
                "\n" +
                "pobi : --\n" +
                "suhw : --\n" +
                "\n" +
                "pobi : --\n" +
                "suhw : ---\n" +
                "\n";
        //then
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectedResult);
        System.setOut(System.out);
    }
}
