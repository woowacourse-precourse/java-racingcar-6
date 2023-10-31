package racingcar.domain.car;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.CarMovementStrategy;
import racingcar.domain.car.strategy.MoveForwardOnceRandomlyStrategy;
import racingcar.dto.CarInformationDto;
import racingcar.dto.CarsInformationDto;

public class CarsGetInformationTest {

    @Test
    @DisplayName("Cars클래스가 CarsInformationDto를 올바르게 반환한다.")
    void CarsGetInformationTest() {
        // given
        String name1 = "차1";
        String name2 = "차2";
        String name3 = "차3";
        CarMovementStrategy carMovementStrategy = new MoveForwardOnceRandomlyStrategy();

        Cars cars = new Cars(
                List.of(
                        new Car(name1, carMovementStrategy),
                        new Car(name2, carMovementStrategy),
                        new Car(name3, carMovementStrategy)
                )
        );

        // when
        CarsInformationDto carsInformationDto = cars.getInformation();
        CarsInformationDto expectedCarsInformationDto = new CarsInformationDto(
                List.of(
                        new CarInformationDto(name1, 0),
                        new CarInformationDto(name2, 0),
                        new CarInformationDto(name3, 0)
                )
        );

        // then
        Assertions.assertEquals(carsInformationDto, expectedCarsInformationDto);
    }

}
