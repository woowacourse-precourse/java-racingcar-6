package racingcar.model.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnersTest {

    @Test
    public void 우승자들의_이름반환() {
        List<Car> winners = Arrays.asList(
                new Car("hwan"),
                new Car("park")
        );

        Winners winnersResult = new Winners(winners);

        List<String> expectedWinnerNames = Arrays.asList("hwan", "park");
        assertEquals(expectedWinnerNames, winnersResult.getWinnerNames());
    }
}
