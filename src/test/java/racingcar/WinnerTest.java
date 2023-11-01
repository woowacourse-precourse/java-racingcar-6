package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import racingcar.model.RacingCarService;

public class WinnerTest {
    @Mock
    private RacingCarService service = new RacingCarService((minBound, maxBound) -> 4);

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
        service.createCarList(userInputCarNames);

        //when
        String winner = service.findWinner();

        //then
        assertEquals("a, b, c", winner);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    void 혼자_레이싱하면_우승자는_자기자신이다(int tryNumber) {
        //given
        String userInputCarNames = "a";
        service.createCarList(userInputCarNames);

        //when
        for (int i = 0; i < tryNumber; i++) {
            service.move();
        }

        //then
        assertEquals(userInputCarNames, service.findWinner());
    }
}
