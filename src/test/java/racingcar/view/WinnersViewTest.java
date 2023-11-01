package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.WinnersDTO;

class WinnersViewTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @Test
    void 우승자_결과를_출력() {
        WinnersDTO winnersDTO = new WinnersDTO(Arrays.asList("pobi", "jun"));
        WinnersView winnersView = new WinnersView(winnersDTO);

        winnersView.view();

        assertEquals("최종 우승자 : pobi, jun", outputMessage.toString());
    }
}