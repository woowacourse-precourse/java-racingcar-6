package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerStandTest {

    @Test
    void 우승자_이름_문자열을_올바르게_생성() {
        // Given
        WinnerStand winnerStand = new WinnerStand();
        List<String> winnerNames = List.of("a", "b", "c");
        String expectedResult = "a, b, c";

        // When
        winnerNames.forEach(winnerStand::addWinner);
        String actualResult = winnerStand.getWinners();

        // Then
        assertEquals(expectedResult, actualResult);
    }
}