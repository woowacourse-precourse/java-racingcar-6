package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.dto.CarDto;

class CarTest {

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"k", "stark"})
    @DisplayName(("자동차 이름 검증 통과"))
    void givenName_whenCreateCar_thenNoException(String name) {
        assertThatNoException().isThrownBy(() -> new Car(name));
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"", "  ", "pooobi", " pobi", "pobi ", "po bi"})
    @DisplayName("자동차 이름 검증 실패")
    void givenName_whenCreateCar_thenThrowException(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이면 자동차 전진")
    void givenNumber_whenMove_thenIncreasePosition() {
        Car car = new Car("pobi");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 4 미만이면 자동차 멈춤")
    void givenNumber_whenMove_thenStop() {
        Car car = new Car("pobi");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 위치 비교: 똑같은 위치")
    void givenTwoCar_whenIsSamePosition_thenReturnTrue() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        assertThat(pobi.isSamePosition(woni)).isTrue();
    }

    @Test
    @DisplayName("자동차 위치 비교: 다른 위치")
    void givenTwoCar_whenIsSamePosition_thenReturnFalse() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        pobi.move(4);

        assertThat(pobi.isSamePosition(woni)).isFalse();
    }

    @Test
    @DisplayName("CarDto 생성 확인")
    void givenCar_thenToCarDto_thenSuccess() {
        Car pobi = new Car("pobi");
        pobi.move(4);

        CarDto result = pobi.toCarDto();

        assertThat(result).extracting("name").isEqualTo("pobi");
        assertThat(result).extracting("position").isEqualTo(1);
    }

}
