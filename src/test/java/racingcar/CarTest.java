package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤넘버가 4이상일 때 움직이는지 확인")
    void 차_이동_테스트(int number) {
        //given
        Car car = new Car("test");
        int position = car.getPosition();
        //when
        car.move(number);
        //then
        assertThat(car.getPosition()).isEqualTo(position + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤넘버가 4미만일 때 안 움직이는지 확인")
    void 차_정지_테스트(int number) {
        //given
        Car car = new Car("test");
        int position = car.getPosition();
        //when
        car.move(number);
        //then
        assertThat(car.getPosition()).isEqualTo(position);
    }


}