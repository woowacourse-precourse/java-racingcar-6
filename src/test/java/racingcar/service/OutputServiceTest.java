package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputServiceTest {
    public static final String WINNERS = "최종 우승자 : ";

    @Test
    @DisplayName("성공 : 최종 우승자 출력")
    void gameResultMessageForSuccess() {
        // given
        List<String> candidates = Arrays.asList("pobi", "woni", "jun");

        GameService.racingResult = new LinkedHashMap<>();

        GameService.racingResult.put("pobi", "--");
        GameService.racingResult.put("woni", "--");
        GameService.racingResult.put("jun", "---");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        
        System.setOut(new PrintStream(outputStream));

        // when
        OutputService.gameResultMessage(candidates);
        System.setOut(originalOut);

        // then
        String expectedOutput = WINNERS + "pobi, woni\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
