package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.global.enums.ExceptionMessage.EXCEED_MAX_LENGTH_MESSAGE;
import static racingcar.global.enums.ExceptionMessage.NAME_HAS_WHITE_SPACE_MESSAGE;

import org.junit.jupiter.api.Test;
import racingcar.TestUtils;

class CarTest {

    @Test
    void 길이_초과_객체_생성_실패_테스트() {
        //given
        String name = TestUtils.generateNameExceedingMaxLength();

        //when and then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEED_MAX_LENGTH_MESSAGE.getMessage());
    }

    @Test
    void 공백_포함_객체_생성_실패_테스트() {
        //when and then
        assertThatThrownBy(() -> new Car(" a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_HAS_WHITE_SPACE_MESSAGE.getMessage());
    }

    @Test
    void 전진_기능_작동_테스트() {
        //given
        Car car = new Car("a");
        int expectedMoveCount = 1;

        //when
        car.moveForward();

        //then
        assertThat(car.getPosition()).isEqualTo(expectedMoveCount);
    }

    @Test
    void Equals_테스트() {
        //given
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("a");

        //when and then
        assertTrue(car1.equals(car1));
        assertTrue(car1.equals(car3));
        assertTrue(car3.equals(car1));
        assertFalse(car1.equals(car2));
        assertFalse(car2.equals(car1));
    }

    @Test
    void hash_code_테스트() {
        //given
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("a");

        //when and then
        assertThat(car1.hashCode()).isEqualTo(car3.hashCode());
        assertThat(car1.hashCode()).isNotEqualTo(car2.hashCode());
    }

}