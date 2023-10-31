package racingcar.domain.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.MoveForwardOnceRandomlyStrategy;
import racingcar.dto.CarInformationDto;

public class CarGetInformationTest {

    @Test
    @DisplayName("Car클래스가 CarInformationDto를 올바르게 반환한다.")
    void CarGetInformationTest() {
        // given
        String carName = "이름";
        Car car = new Car(carName, new MoveForwardOnceRandomlyStrategy());

        // when
        CarInformationDto carInformationDto = car.getInformation();
        String name = carInformationDto.name();
        int position = carInformationDto.position();

        // then
        Assertions.assertEquals(position, 0);
        Assertions.assertEquals(name, carName);
    }

}
