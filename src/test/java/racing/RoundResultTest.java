package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.result.CarResult;
import racingcar.domain.result.RoundResult;

public class RoundResultTest {
    @Test
    void getCarResultsTest() {

        CarResult carResultA = new CarResult("pobi", 2);
        CarResult carResultB = new CarResult("woni", 3);
        List<CarResult> givenCarResults = Arrays.asList(carResultA, carResultB);

        RoundResult roundResult = new RoundResult(givenCarResults);

        List<CarResult> retrievedCarResults = roundResult.getCarResults();

        assertThat(retrievedCarResults).containsExactly(carResultA, carResultB);
    }
}
