package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.enums.CarType;
import racingcar.enums.Common;
import racingcar.view.OutputView;

import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayResultsTest {
    @Test
    void PlayResults() {
        String input = "isaac,pobi";
        Cars cars = new Cars(input);
        new PlayResults(cars);
    }

    @Test
    void getResults() {
        String input = "isaac,pobi";
        Cars cars = new Cars(input);

        assertRandomNumberInRangeTest(() -> {
                    cars.everyCarMoveForward();
                    cars.everyCarMoveForward();

                    PlayResults playResults = new PlayResults(cars);
                    assertThat(playResults.getResults()
                            .stream()
                            .map(result -> result.get(CarType.CAR_NAME))
                            .collect(Collectors.joining(","))
                    ).isEqualTo(input);

                    assertThat(playResults.getResults()
                            .stream()
                            .map(result -> result.get(CarType.DISTANCE))
                            .collect(Collectors.joining(","))
                    ).isEqualTo("--,-");

                    assertThat(playResults.getResults()
                            .stream()
                            .map(result -> String.format("%s : %s",result.get(CarType.CAR_NAME),result.get(CarType.DISTANCE)))
                            .collect(Collectors.joining("\n"))
                    ).isEqualTo("isaac : --\npobi : -");
                },
                Common.STANDARD_NUMBER.getIntValue(),
                Common.STANDARD_NUMBER.getIntValue(),
                Common.STANDARD_NUMBER.getIntValue(),
                Common.STANDARD_NUMBER.getIntValue() - 1
        );
    }

}