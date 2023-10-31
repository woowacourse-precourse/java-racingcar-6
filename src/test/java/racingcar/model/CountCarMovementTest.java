package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountCarMovementTest {
    CountCarMovement countCarMovement;

    @BeforeEach
    void reset() {
        countCarMovement = CountCarMovement.createCountCarMovement(3);
    }

    @Test
    @DisplayName("winnersIndex 동작 확인")
    void testWinnersIndex() {
        //given
        countCarMovement.forwardCar(0);
        countCarMovement.forwardCar(2);

        //when
        List<Integer> winnerIndex = new ArrayList<>();
        winnerIndex = countCarMovement.winnersIndex();

        //then
        Assertions.assertThat(winnerIndex).isEqualTo(Arrays.asList(0, 2));

    }
}