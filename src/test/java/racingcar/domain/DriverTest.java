package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DriverTest {
    @Test
    void driveTest_whenNumber0(){
        // Given
        Driver driver = new RandomDriver();

        // When
        int result = driver.getNumber();

        //Then
        Assertions.assertThat(result).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(result).isLessThanOrEqualTo(9);
    }
}
