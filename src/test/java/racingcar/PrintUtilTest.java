package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.MessageConst.*;
import static racingcar.PrintUtil.*;

class PrintUtilTest {

    private static OutputStream out;
    private StringBuilder expectedResult;

    @BeforeEach
    void setUp() {
        expectedResult = new StringBuilder();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void resetStream() {
        System.setOut(System.out);
    }

    @ParameterizedTest
    @MethodSource("provideGameResult")
    void 게임_결과_출력(Map<String, String> result) {
        printGameResultMsg(result);

        String expectedResult = generateGameResult(result);

    @ParameterizedTest
    @MethodSource("provideOneWinner")
    void 게임_우승자_한명_출력(Map<String, String> result, List<String> winner) {
        printWinnerMsg(result, winner);

        expectedResult.append("최종 우승자 : woni");

        assertThat(out.toString()).isEqualTo(expectedResult.toString());
    }

    @ParameterizedTest
    @MethodSource("provideTwoWinner")
    void 게임_우승자_두명_출력(Map<String, String> result, List<String> winner) {
        printWinnerMsg(result, winner);

        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("최종 우승자 : pobi, woni");

        assertThat(out.toString()).isEqualTo(expectedResult.toString());
    }

    @ParameterizedTest
    @MethodSource("provideThreeWinner")
    void 게임_우승자_세명_출력(Map<String, String> result, List<String> winner) {
        printWinnerMsg(result, winner);

        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("최종 우승자 : pobi, woni, jun");

        assertThat(out.toString()).isEqualTo(expectedResult.toString());
    }

    private static String generateGameResult(Map<String, String> result) {
        StringBuilder expectedResult = new StringBuilder();
        for (Map.Entry<String, String> entrySet : result.entrySet()) {
            expectedResult.append(entrySet.getKey()).append(" : ").append(entrySet.getValue()).append("\n");
        }
        expectedResult.append("\n");

        return expectedResult.toString();
    }

    private static Stream<Map<String, String>> provideGameResult() {
        return Stream.of(
                new LinkedHashMap<String, String>() {{
                    put("pobi", "-----");
                    put("woni", "----");
                    put("jun", "----");
                }},
                new LinkedHashMap<String, String>() {{
                    put("pobi", "-----");
                    put("woni", "----");
                    put("jun", "-----");
                }},
                new LinkedHashMap<String, String>() {{
                    put("pobi", "-----");
                    put("woni", "-----");
                    put("jun", "-----");
                }}
        );
    }

    private static String generateWinnerReuslt(Map<String, String> result, List<String> winner) {

        StringBuilder gameWinner = new StringBuilder();

        gameWinner.append(WINNER_MESSAGE);

        String winnerScore = result.get(winner.get(0));
        gameWinner.append(winner.get(0));
        for (int i = 1; i < winner.size(); i++) {
            if (winnerScore.equals(result.get(winner.get(i)))) {
                gameWinner.append(", ").append(winner.get(i));
            }
        }

        return gameWinner.toString();
    }

    private static Stream<Arguments> provideWinner() {
        return Stream.of(
                Arguments.of(new LinkedHashMap<String, String>() {{
                    put("pobi", "---");
                    put("woni", "-----");
                    put("jun", "--");
                }}, Arrays.asList("woni", "pobi", "jun")),

                Arguments.of(new LinkedHashMap<String, String>() {{
                    put("pobi", "-----");
                    put("woni", "-----");
                    put("jun", "--");
                }}, Arrays.asList("pobi", "woni", "jun")),

                Arguments.of(new LinkedHashMap<String, String>() {{
                    put("pobi", "--");
                    put("woni", "--");
                    put("jun", "--");
                }}, Arrays.asList("pobi", "woni", "jun"))
        );
    }
}