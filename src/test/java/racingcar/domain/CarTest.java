package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class CarTest {

    @Test
    @DisplayName("자동차의 초기위치는 0")
    void 초기_위치_0() {
        // given
        String name = "1234";

        // when
        Car car = Car.from(name);

        // then
        assertThat(car.getNameString()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345", " a", "a ", "a a"})
    @DisplayName("이름 길이는 5이하 가능")
    void 이름길이_5_이하(String name) {

        Car car = Car.from(name);

        assertThat(car.getNameString()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "abcdef", "12345678", "123456789", "123456789012345"})
    @DisplayName("이름 길이는 5초과 불가능")
    void 이름길이_5초과_예외(String name) {
        assertThatThrownBy(() -> Car.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름 길이는 5 이하만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "   "})
    @DisplayName("빈문자는 생성 불가능")
    void 빈문자_예외(String name) {

        assertThatThrownBy(() -> Car.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 빈칸일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,10,100,1000,99999})
    @DisplayName("숫자 4이상일 떄 이동")
    void 숫자_4이상만_이동(int number) {
        // given
        Car car = Car.from("car");

        // when
        car.go(number);

        // then
        assertThat(car.getPosition()).isEqualTo(new Position(1));
        car.isHere(new Position(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {-999,-1,0,1,2,3})
    @DisplayName("숫자 4미만 이동불가")
    void 숫자_4_미만_이동불가(int number) {
        // given
        Car car = Car.from("1234");

        // when
        car.go(number);

        // then
        assertThat(car.getPosition()).isEqualTo(new Position(0));
        car.isHere(new Position(0));
    }

    @Test
    void Position_안정성_테스트() {
        // given
        Car car = Car.from("a");

        // when
        Position position = car.getPosition();
        position = new Position(1);


        // then
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }

    @Test
    void Position_안정성_테스트_2() {
        // given
        Car car = Car.from("a");

        // when
        Position position = car.getPosition();
        position.plus();

        // then
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }


}