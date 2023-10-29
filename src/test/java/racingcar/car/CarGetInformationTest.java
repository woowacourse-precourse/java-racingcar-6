package racingcar.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.dto.CarInformationDto;

public class CarGetInformationTest {

    @Test
    @DisplayName("Car클래스가 CarInformationDto를 올바르게 반환한다.")
    void CarGetInformationTest() {
        // given
        String givenName = "이름";
        CarName carName = new CarName(givenName);
        Car car = new Car(carName);

        // when
        CarInformationDto carInformationDto = car.getInformation();
        String name = carInformationDto.name();
        int position = carInformationDto.position();

        // then
        Assertions.assertEquals(position, 0);
        Assertions.assertEquals(name, givenName);
    }

}
