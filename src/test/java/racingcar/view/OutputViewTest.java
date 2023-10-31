package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    @DisplayName("경기 결과 출력 테스트")
    void outputCarMoveResultTest() {
        // given
        Map<String, Integer> carData = new LinkedHashMap<>();
        carData.put("pobi", 3);
        carData.put("woni", 6);
        carData.put("jun", 2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        // when
        outputView.outputCarMoveResults(carData);
        String consoleOutput = outputStream.toString().trim();
        // then
        Assertions.assertThat(consoleOutput).isEqualTo(
                "실행 결과\n" +
                        "pobi : ---\n" +
                        "woni : ------\n" +
                        "jun : --"
        );
    }

    @Test
    @DisplayName("최종 우승자가 pobi 일때 최종 우승자 : pobi 여야한다")
    void outputWinnerResultTest() {
        // given
        List<String> winner = Arrays.asList("pobi");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        outputView.outputWinnerResult(winner);
        String consoleOutput = outputStream.toString().trim();

        // then
        Assertions.assertThat(consoleOutput).isEqualTo(
                "최종 우승자 : pobi"
        );
    }

    @Test
    @DisplayName("최종 우승자가 pobi, jun 일때 최종 우승자 : pobi, jun 여야한다")
    void outputWinnersResultTest() {
        // given
        List<String> winners = Arrays.asList("pobi","jun");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        outputView.outputWinnerResult(winners);
        String consoleOutput = outputStream.toString().trim();

        // then
        Assertions.assertThat(consoleOutput).isEqualTo(
                "최종 우승자 : pobi, jun"
        );
    }
}