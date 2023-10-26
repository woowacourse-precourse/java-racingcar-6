package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {


    @DisplayName("차 이동을 호출한 횟수와 차의 위치는 같아야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,4,9})
    void 차_이동_테스트 (int maxTryCount) {

        //given
        Car car = new Car(new Name("test"));

        //when
        int tryCount = 0;
        while (tryCount < maxTryCount) {
            car.move();
            tryCount++;
        }

        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(maxTryCount);
    }

}