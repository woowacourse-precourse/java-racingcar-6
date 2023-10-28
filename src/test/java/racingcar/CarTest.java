package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;
    private NumberGenerator mockNumberGenerator;

    @BeforeEach
    void setUp() {
        mockNumberGenerator = mock(NumberGenerator.class);
        car = new Car("TestCar", mockNumberGenerator);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 랜덤숫자가_4이상일떄_자동차_전진(int randomNumber) {
        int expectedMoveNum = 1;
        when(mockNumberGenerator.createRandomNumber()).thenReturn(randomNumber);
        car.move();
        assertThat(car.getMoveNum()).isEqualTo(expectedMoveNum);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤숫자가_4미만일때_자동차_멈춤(int randomNumber) {
        int expectedMoveNum = 0;
        when(mockNumberGenerator.createRandomNumber()).thenReturn(randomNumber);
        car.move();
        assertThat(car.getMoveNum()).isEqualTo(expectedMoveNum);
    }
}
