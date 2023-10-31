package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @DisplayName("쉼표 기준으로 파싱하는 기능 테스트")
    @Test
    void testParser() {
        String names = "pobi,woni,jun";
        List<String> expected = List.of("pobi", "woni", "jun");

        Parser parser = new Parser();
        List<String> carNames = parser.carNameParser(names);

        assertEquals(expected, carNames);
    }
}
