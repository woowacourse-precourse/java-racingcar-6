package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientGameNumberTest {

    @Test
    public void testValidInput() {
        // given
        Integer numberOfGames = 4;

        // when
        ClientGameNumber clientGameNumber = new ClientGameNumber(numberOfGames);

        // then
        Integer result = clientGameNumber.getNumberOfGames();
        assertEquals(numberOfGames, result);
    }

    @Test
    public void testInvalidNames() {
        // given
        Integer numberOfGames = -1;

        // when and then
        assertThrows(IllegalArgumentException.class, () -> {
            ClientGameNumber clientGameNumber = new ClientGameNumber(-1);
        });
    }
}