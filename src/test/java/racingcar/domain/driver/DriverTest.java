package racingcar.domain.driver;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DriverTest {

    @DisplayName("운전자는 운전명령을 내린 후 움직임 이후 결과를 나타낸 메시지를 반환한다.")
    @Test
    void commandMove() {
        //give
        String carName = "5uhwann";
        Car car = new Car(carName);
        Driver driver = new Driver(car);

        //when
        String result = driver.commandMovement();

        //then
        assertThat(result).contains("5uhwann : ");
    }

}
