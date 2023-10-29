package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.PrintUtil.*;
class PrintUtilTest {

    private static OutputStream out;
    @BeforeEach
    void setUp() {
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

        assertThat(out.toString().replace(System.lineSeparator(), "\n")).isEqualTo(expectedResult);
    }

    private static String generateGameResult(Map<String, String> result) {
        StringBuilder expectedResult = new StringBuilder();
        for(Map.Entry<String, String> entrySet : result.entrySet()) {
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
}