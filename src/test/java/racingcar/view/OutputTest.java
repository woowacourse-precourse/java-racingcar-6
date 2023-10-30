package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarController;
import racingcar.model.RacingCarService;

public class OutputTest {
    RacingCarService service = new RacingCarService();
    RacingCarController controller = new RacingCarController();

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    void 레이싱을_0번했을때_모든_사용자가_우승한다() {
        //given
        String userInputCarNames = "a,b,c";
        List<String> carNameList = service.createCarNameList(userInputCarNames);
        service.createCarList(carNameList);

        //when
        String winner = service.findWinnerByCarPosition();

        //then
        assertEquals("a, b, c", winner);
    }
}
