package racingcarv2.model;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcarv2.model.Car;
import racingcarv2.model.Name;
import racingcarv2.model.Position;
import racingcarv2.model.RacingCars;

public class RacingCarsTest {
    private RacingCars singleWinner = new RacingCars(Arrays.asList(
            new Car(new Name("a"), new Position(2)),
            new Car(new Name("b"), new Position(1)),
            new Car(new Name("c"), new Position(3))
        )
    );

    private RacingCars multipleWinner = new RacingCars(Arrays.asList(
            new Car(new Name("a"), new Position(2)),
            new Car(new Name("b"), new Position(2)),
            new Car(new Name("c"), new Position(2))
        )
    );

    @Test
    void 단독_우승자_확인() {
        List<Name> singleWinnerName = singleWinner.findWinnerName();

        Assertions.assertThat(singleWinnerName).containsExactly(new Name("c"));
    }

    @Test
    void 복수_우승자_확인() {
        List<Name> multipleWinnerNames = multipleWinner.findWinnerName();

        Assertions.assertThat(multipleWinnerNames).containsExactly(
                new Name("a"), new Name("b"), new Name("c"));
    }
}
