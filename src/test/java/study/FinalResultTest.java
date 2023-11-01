package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.movement.TestMovementStrategy;
import racingcar.domain.result.CarResult;
import racingcar.domain.result.FinalResult;
import racingcar.domain.result.RoundResult;
import racingcar.domain.round.Round;

public class FinalResultTest {

    private TestMovementStrategy testMovementStrategy = mock(TestMovementStrategy.class);
    @Test
    void getRoundResultsTest() {

        Round round1 = new Round(5);
        Car carA = new Car("pobi",testMovementStrategy,round1);
        Car carB = new Car("woni",testMovementStrategy,round1);

        Round round2 = new Round(3);
        Car car1 = new Car("포비",testMovementStrategy,round2);
        Car car2 = new Car("우니",testMovementStrategy,round2);

        RoundResult roundResult1 = new RoundResult(Arrays.asList(new CarResult("pobi", 5), new CarResult("woni", 5)));
        RoundResult roundResult2 = new RoundResult(Arrays.asList(new CarResult("포비", 3), new CarResult("우니", 3)));
        List<RoundResult> roundResults = Arrays.asList(roundResult1, roundResult2);

        FinalResult finalResult = new FinalResult(roundResults, Arrays.asList(carA, car1));

        List<RoundResult> retrievedRoundResults = finalResult.getRoundResults();

        assertThat(retrievedRoundResults).containsExactly(roundResult1, roundResult2);
    }

    @Test
    void getWinnerNamesTest() {

        Round round1 = new Round(5);
        Car carA = new Car("pobi",testMovementStrategy,round1);
        Car carB = new Car("woni",testMovementStrategy,round1);

        Round round2 = new Round(3);
        Car car1 = new Car("포비",testMovementStrategy,round2);
        Car car2 = new Car("우니",testMovementStrategy,round2);

        RoundResult roundResult1 = new RoundResult(Arrays.asList(new CarResult("pobi", 5), new CarResult("woni", 5)));
        RoundResult roundResult2 = new RoundResult(Arrays.asList(new CarResult("포비", 3), new CarResult("우니", 3)));
        List<RoundResult> roundResults = Arrays.asList(roundResult1, roundResult2);

        FinalResult finalResult = new FinalResult(roundResults, Arrays.asList(carA, car1));

        List<String> winnerNames = finalResult.getWinnerNames();

        assertThat(winnerNames).containsExactly("pobi", "포비");
    }
}
