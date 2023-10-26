package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.driver.Driver;

import java.util.List;

class DriverTest {
    @Test
    void driverTest() {
        // Given
        Driver driver = new Driver();
        String drivers = "BTS, 손흥민, 봉준호, 김태훈";

        // When
        List<String> result = driver.validateDriverLineUp(drivers);

        // Then
        System.out.println(result);
    }
}