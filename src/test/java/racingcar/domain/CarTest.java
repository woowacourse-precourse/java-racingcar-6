package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        // given
        Car car = new Car("pobi");

        // when
        car.move(4);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 4 미만이면 자동차 멈춤")
    void givenNumber_whenMove_thenStop() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 위치 비교: 똑같은 위치")
    void givenTwoCar_whenIsSamePosition_thenReturnTrue() {
        // given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        // when & then
        assertThat(pobi.isSamePosition(woni)).isTrue();
    }

    @Test
    @DisplayName("자동차 위치 비교: 다른 위치")
    void givenTwoCar_whenIsSamePosition_thenReturnFalse() {
        // given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        pobi.move(4);

        // when & then
        assertThat(pobi.isSamePosition(woni)).isFalse();
    }

}
