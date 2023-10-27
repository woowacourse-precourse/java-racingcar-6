package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private static final String NAME = "pobi";
    Car car;

    @BeforeEach
    void reset() {
        car = new Car(NAME);
    }

    @Test
    @DisplayName("forwardCar 매개변수 false 시 멈춤 확인")
    void carStop() {
        //given
        reset();

        //when
        car.forwardCar(false);

        //then
        Assertions.assertThat(car.carResult()).isEqualTo(0);
    }

    @Test
    @DisplayName("forwardCar 매개변수 true 시 전진 확인")
    void testCarMove() {
        //given

        //when
        car.forwardCar(true);

        //then
        Assertions.assertThat(car.carResult()).isEqualTo(1);
    }

    @Test
    @DisplayName("forwardCar 호출 된 만큼 자동차 전진 확인")
    void testCarMoveRepeat() {
        //given
        int number = 10;

        //when
        for (int i = 0; i < number; i++) {
            car.forwardCar(true);
        }

        //then
        Assertions.assertThat(car.carResult()).isEqualTo(number);
    }

    @Test
    @DisplayName("ifImWinner 매개 변수 값과 다르면 공백 반환 확인")
    void testNotWinner() {
        //given
        String winnerName;
        car.forwardCar(true);

        //when
        winnerName = car.ifImWinner(2);

        //then
        Assertions.assertThat(winnerName).isEqualTo("");
    }

    @Test
    @DisplayName("ifImWinner 매개 변수 값과 같으면 반환 확인")
    void testWinner() {
        //given
        String winnerName;
        car.forwardCar(true);
        car.forwardCar(true);

        //when
        winnerName = car.ifImWinner(2);

        //then
        Assertions.assertThat(winnerName).isEqualTo(NAME);
    }
}