package racingcar.domain.car;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.MoveForwardOnceStrategy;
import racingcar.domain.car.strategy.CarMovementStrategy;
import racingcar.dto.CarNamesDto;

public class CarsFindCarNamesTest {

    @Test
    @DisplayName("원하는 위치값을 가진 차들의 이름을 찾을 수 있다.")
    void findCarNamesByPosition() {
        // given
        CarMovementStrategy carMovementStrategy = new MoveForwardOnceStrategy();
        String name1 = "차1";
        String name2 = "차2";
        String name3 = "차3";
        Car car1 = new Car(name1, carMovementStrategy);
        Car car2 = new Car(name2, carMovementStrategy);
        Car car3 = new Car(name3, carMovementStrategy);

        Cars cars = new Cars(
                List.of(car1, car2, car3)
        );

        // when
        car3.move();
        CarNamesDto carNamesDto = cars.findCarNamesByPosition(0);
        CarNamesDto expectedCarNamesDto = new CarNamesDto(List.of(name1, name2));

        // then
        Assertions.assertEquals(carNamesDto, expectedCarNamesDto);
    }

    @Test
    @DisplayName("가장 높은 위치값을 가진 차들의 이름을 찾을 수 있다.")
    void findMaxPositionCarNamesByPosition() {
        // given
        CarMovementStrategy carMovementStrategy = new MoveForwardOnceStrategy();
        String name1 = "차1";
        String name2 = "차2";
        String name3 = "차3";
        Car car1 = new Car(name1, carMovementStrategy);
        Car car2 = new Car(name2, carMovementStrategy);
        Car car3 = new Car(name3, carMovementStrategy);

        Cars cars = new Cars(
                List.of(car1, car2, car3)
        );

        // when
        car1.move();
        car2.move();
        CarNamesDto carNamesDto = cars.findWinnerNames();
        CarNamesDto expectedCarNamesDto = new CarNamesDto(List.of(name1, name2));

        // then
        Assertions.assertEquals(carNamesDto, expectedCarNamesDto);
    }

}
