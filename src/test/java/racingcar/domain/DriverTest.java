package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DriverTest {
    @Test
    void getNumberTest(){
        // Given
        Driver driver = new RandomDriver();

        // When
        int result = driver.getNumber();

        //Then
        assertThat(result).isGreaterThanOrEqualTo(0);
        assertThat(result).isLessThanOrEqualTo(9);
    }
}
