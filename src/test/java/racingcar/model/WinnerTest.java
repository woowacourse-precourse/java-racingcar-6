package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinnerTest {
    private RacingCarService service = new RacingCarService((minBound, maxBound) -> 4);

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
