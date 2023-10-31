package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    void Car생성() {
        Car car = new Car(new CarName("pobi"), new Position(0));
    }

    @Test
    void Car_move함수_호출시_Position값_1증가() {
        //given
        Car car = new Car(new CarName("pobi"), new Position(0));
        //when
        car.move(() -> true);
        //then
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }
}
