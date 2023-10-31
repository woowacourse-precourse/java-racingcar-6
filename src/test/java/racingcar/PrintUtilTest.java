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
        printResultMsg();
        printGameResultMsg(result);
        printFinalResultMsg();

        String expectedResult = generateExpectedGameResult(result);

        assertThat(out.toString()).isEqualTo(expectedResult);
    }

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

    private static String generateExpectedGameResult(Map<String, String> result) {
        StringBuilder expectedResult = new StringBuilder();

        expectedResult.append(LINE_BREAK).append("실행 결과").append(LINE_BREAK);
        result.forEach((Key, Value) -> expectedResult.append(Key).append(" : ").append(Value).append(LINE_BREAK));
        expectedResult.append(LINE_BREAK);

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

    private static Stream<Arguments> provideOneWinner() {
        return Stream.of(
                Arguments.of(new LinkedHashMap<String, String>() {{
                    put("pobi", "---");
                    put("woni", "-----");
                    put("jun", "--");
                }}, Arrays.asList("woni", "pobi", "jun"))
        );
    }

    private static Stream<Arguments> provideTwoWinner() {
        return Stream.of(
                Arguments.of(new LinkedHashMap<String, String>() {{
                    put("pobi", "-----");
                    put("woni", "-----");
                    put("jun", "--");
                }}, Arrays.asList("pobi", "woni", "jun"))
        );
    }

    private static Stream<Arguments> provideThreeWinner() {
        return Stream.of(
                Arguments.of(new LinkedHashMap<String, String>() {{
                    put("pobi", "--");
                    put("woni", "--");
                    put("jun", "--");
                }}, Arrays.asList("pobi", "woni", "jun"))
        );
    }
}