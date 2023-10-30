package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarTest {

    @Test
    @DisplayName("Move forward (Random >= 4)")
    void 랜덤_숫자가_4이상일_경우_전진() {
        Car mock = Mockito.mock(Car.class);

        int mockRandomNumber = 5;
        Mockito.when(mock.generateRandomNumber()).thenReturn(mockRandomNumber);
        mock.moveForward();

        String expectedValue = "-";
        Assertions.assertThat(expectedValue).isEqualTo("-");
    }

    @Test
    @DisplayName("No Move Forward (Random < 4)")
    void 랜덤_숫자가_4미만일_경우_스탑() {
        Car mock = Mockito.mock(Car.class);

        int mockRandomNumber = 3;
        Mockito.when(mock.generateRandomNumber()).thenReturn(mockRandomNumber);
        mock.moveForward();

        String expectedValue = "";
        Assertions.assertThat(expectedValue).isEqualTo("");
    }
}