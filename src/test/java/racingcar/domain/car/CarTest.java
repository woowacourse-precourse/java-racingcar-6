package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Nested
    @DisplayName("Car 도메인 테스트")
    class CarDomainTest {

        @ParameterizedTest
        @ValueSource(ints = {4, 5, 6, 7, 8, 9})
        @DisplayName("랜덤값이 4이상일 경우 성공적으로 이동해야 한다")
        public void 랜덤값이_4이상일_경우_성공적으로_이동해야_한다(int randomNumber) {
            Car car = new Car("Car");

            Car afterRaceCar = car.race(randomNumber);

            assertThat(afterRaceCar.getPosition()).isEqualTo(1);
            assertThat(afterRaceCar.getName()).isEqualTo("Car");
        }
    }

}
