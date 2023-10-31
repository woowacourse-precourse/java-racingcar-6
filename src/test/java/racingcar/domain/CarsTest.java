package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.response.GameResultDto;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<String> carNames = Arrays.asList("용준", "용준1", "용준2");
        cars = new Cars(carNames);
    }

    @Test
    void playGameShouldNotThrowException() {
        assertDoesNotThrow(() -> cars.playGame());
    }

    @Test
    void getWinnerShouldReturnNotNullAndNotEmpty() {
        cars.playGame();
        GameResultDto result = cars.getWinner();

        assertNotNull(result);
        assertTrue(result.winners().size() > 0);
    }
}