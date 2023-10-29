package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;


class PrintUtilTest {

    private static OutputStream out;


    @Test
    void 게임_결과_출력() {

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