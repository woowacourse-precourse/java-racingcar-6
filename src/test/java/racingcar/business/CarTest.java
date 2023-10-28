package racingcar.business;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void 생성자로_부여한_자동차_이름_일치여부_확인() {
        String pobi = "pobi";

        Car pobisCar = new Car(pobi);

        assertThat(pobisCar.getName()).isEqualTo(pobi);
    }

    @Test
    void 자동차에_4를_전달할_경우_distance_1_증가() {
        Car fourCar = new Car("four");

        fourCar.moveCar(4);

        assertThat(fourCar.getDistance()).isEqualTo(1);
    }

    @Test
    void 자동차에_4이상의_값을_전달할_경우_distance_1_증가() {
        Car fiveCar = new Car("five");

        fiveCar.moveCar(5);

        assertThat(fiveCar.getDistance()).isEqualTo(1);
    }

    @Test
    void 자동차에_4미만의_값을_전달할_경우_distance_증가하지_않음() {
        Car threeCar = new Car("three");

        threeCar.moveCar(3);

        assertThat(threeCar.getDistance()).isEqualTo(0);
    }

    @Test
    void 자동차에_부여된_숫자가_범위를_넘어서는_경우_예외_발생() {
        Car exceptoinCar = new Car("exception");

        assertThatThrownBy(() -> exceptoinCar.moveCar(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 숫자의 범위가 일치하지 않습니다.");
    }

}