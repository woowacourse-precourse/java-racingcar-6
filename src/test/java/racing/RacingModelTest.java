package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.movement.MovementStrategy;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.domain.result.FinalResult;
import racingcar.model.RacingModel;

public class RacingModelTest {

    private RacingModel racingModel;
    private MovementStrategy movementStrategy;

    @BeforeEach
    void setUP() {
        racingModel = new RacingModel();
        movementStrategy = mock(RandomMovementStrategy.class);
    }

    @Test
    void all_cars_win() {
        String[] carsName = {"pobi","woni","jun"};
        int finalRound = 5;
        when(movementStrategy.couldMove()).thenReturn(true);

        FinalResult finalResult = racingModel.startRacing(carsName,finalRound);

        assertThat(finalResult).isNotNull();
        assertThat(finalResult.getRoundResults()).hasSize(5);
        assertThat(finalResult.getWinnerNames().stream()
                .allMatch(winnerName -> true));
    }

    @Test
    void winner_does_not_exist() {
        String[] carsName = {"pobi","woni","jun"};
        int finalRound = 5;
        when(movementStrategy.couldMove()).thenReturn(false);

        FinalResult finalResult = racingModel.startRacing(carsName,finalRound);

        assertThat(finalResult).isNotNull();
        assertThat(finalResult.getRoundResults()).hasSize(5);
        assertThat(finalResult.getWinnerNames().stream()
                .noneMatch(winnerName -> false));
    }
}
