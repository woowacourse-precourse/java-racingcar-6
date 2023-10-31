package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.CarConstant.CAR_CAN_GO_NUMBER;
import static racingcar.constant.CarConstant.CAR_START_POSITION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class CarTest {

    @DisplayName("자동차의 초기위치는 " + CAR_START_POSITION + "이다.")
    @Test
    void from() {
        // given
        String name = "1234";

        // when
        Car car = Car.from(name);

        // then
        assertThat(car.getNameString()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(new Position(CAR_START_POSITION));
    }

    @DisplayName("숫자 " + CAR_CAN_GO_NUMBER + "이상일 떄 이동할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,10,100,1000,99999})
    void go(int number) {
        // given
        Car car = Car.from("car");

        // when
        car.go(number);

        // then
        assertThat(car.getPosition()).isEqualTo(new Position(1));
        car.isHere(new Position(1));
    }

    @DisplayName("숫자 " + CAR_CAN_GO_NUMBER + "미만 이동 불가능")
    @ParameterizedTest
    @ValueSource(ints = {-999,-1,0,1,2,3})
    void hold(int number) {
        // given
        Car car = Car.from("1234");

        // when
        car.go(number);

        // then
        assertThat(car.getPosition()).isEqualTo(new Position(CAR_START_POSITION));
        assertThat(car.isHere(new Position(CAR_START_POSITION))).isTrue();
    }

    @DisplayName("재할당으로부터 보호된다.")
    @Test
    void getPositionNewPosition() {
        // given
        Car car = Car.from("a");

        // when
        Position position = car.getPosition();
        position = new Position(1);


        // then
        assertThat(car.getPosition()).isEqualTo(new Position(CAR_START_POSITION));
    }

    @DisplayName("외부에서 위치를 임의로 변경할 수 없다.")
    @Test
    void getPositionPlus() {
        // given
        Car car = Car.from("a");

        // when
        Position position = car.getPosition();
        position.plus();

        // then
        assertThat(car.getPosition()).isEqualTo(new Position(CAR_START_POSITION));
    }

}