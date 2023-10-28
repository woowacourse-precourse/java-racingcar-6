package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1, 0", "2, 0", "3, 0", "4, 1", "5, 1", "6, 1", "7, 1", "8, 1", "9, 1"})
    @DisplayName("랜덤값에 따라 자동차 전진/멈추기 테스트")
    void moveOrStop_동작_확인(int randomValue, int expected) {
        try (MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(randomValue);

            Car car = new Car("붕붕카");
            car.moveOrStop();

            assertThat(car.getPath()).isEqualTo(expected);
        }
    }
}