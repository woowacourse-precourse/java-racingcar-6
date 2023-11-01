package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.driver.Driver;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class DriverTest {
    @Test
    void makeDriverRosterTest() {
        // Given
        Driver driver = new Driver();
        String drivers = "BTS,손흥민,봉준호,김태훈";

        // When
        Map<String, String> result = driver.makeDriverRoster(drivers);

        // Then
        System.out.println(result);
    }

    @Test
    void validateDriverRosterTest() {
        // Given
        Driver driver = new Driver();
        String drivers = "BTS,손흥민,봉준호,김태훈김태훈";
        Map<String, String> driverRoster = driver.makeDriverRoster(drivers);

        // When and Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> driver.validateDriverRoster(driverRoster))
                .withMessage("이름은 5자 이하로 입력해주세요.");
    }
}