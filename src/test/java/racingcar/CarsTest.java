package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import generator.NumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;
import racingcar.domain.Cars;

public class CarsTest {

    @Test
    @DisplayName("5의 수를 받았을 경우 이동 여부")
    void move_test() {
        //G
        NumberGenerator generator = new NumberGenerator(5);

        Cars cars = new Cars(List.of(
                new Car(new CarName("호빵맨"), new CarPosition(5)),
                new Car(new CarName("식빵맨"), new CarPosition(3)),
                new Car(new CarName("카레빵맨"), new CarPosition(4))
        ));
        //W
        Cars carsAfterRound = cars.simulateNextRound(generator);
        //T
        assertThat(carsAfterRound).usingRecursiveComparison().isEqualTo(new Cars(List.of(
                new Car(new CarName("호빵맨"), new CarPosition(6)),
                new Car(new CarName("식빵맨"), new CarPosition(4)),
                new Car(new CarName("카레빵맨"), new CarPosition(5))
        )));
    }

}
