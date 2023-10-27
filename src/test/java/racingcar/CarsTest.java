package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @DisplayName("가장 멀리나간 자동차를 구하는 기능.")
    @Test
    void findWinningCars_가장_멀리나간_차들(){
        Cars cars=new Cars(Arrays.asList(
                new Car(new Name("pobi"),new Position(2)),
                new Car(new Name("woni"),new Position(3)),
                new Car(new Name("jun"),new Position(1)),
                new Car(new Name("ski"),new Position(3))
        ));

        List<Car> winningCars=cars.findWiiningCars();

        assertThat(winningCars).contains(new Car(new Name("ski"),new Position(3)),new Car(new Name("woni"),new Position(3)));
        assertThat(winningCars).containsExactly(new Car(new Name("ski"),new Position(3)),new Car(new Name("woni"),new Position(3)));
    }
}
