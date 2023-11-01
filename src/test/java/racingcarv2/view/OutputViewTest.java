package racingcarv2.view;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcarv2.model.Car;
import racingcarv2.model.Name;
import racingcarv2.model.Position;
import racingcarv2.model.RacingCars;

public class OutputViewTest extends IOTest {
    private RacingCars racingCars = new RacingCars(Arrays.asList(
            new Car(new Name("apple"), new Position(1)),
            new Car(new Name("bana"), new Position(3)),
            new Car(new Name("candy"), new Position(3)))
    );

    @Test
    void 각_라운드_결과_출력() {
        OutputView.printEachRound(racingCars.getRacingCars());

        Assertions.assertThat(output()).contains("apple : -", "bana : ---", "candy : ---");
    }

    @Test
    void 최종_결과_출력() {
        OutputView.printWinnerNames(racingCars.findWinnerName());

        Assertions.assertThat(output()).isEqualTo("최종 우승자 : bana, candy\n");
    }


}
