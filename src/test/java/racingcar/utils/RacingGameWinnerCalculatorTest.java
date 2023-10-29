package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.result.RacingCarResult;

class RacingGameWinnerCalculatorTest {

    private List<RacingCarResult> results;

    @BeforeEach
    void setUp() {
        results = new ArrayList<>();
        results.add(new RacingCarResult("one", 3));
        results.add(new RacingCarResult("two", 4));
        results.add(new RacingCarResult("three", 3));
    }

    @Test
    void getWinners() {
        List<String> winners = RacingGameWinnerCalculator.getWinners(results);

        Assertions.assertThat(winners).contains("two");
    }
}
