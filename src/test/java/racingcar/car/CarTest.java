package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 객체 테스트")
    @Test
    void 자동차_객체_테스트() {
        String name = "pobi";
        Car car = new Car(name);
        Assertions.assertThat(car.carName()).isEqualTo(name);
        Assertions.assertThat(car.carPosition()).isEqualTo(0);
    }

    @Test
    void 자동차들_테스트() {
        String[] carName = {"pobi", "zambo"};
        CarList carList = new CarList(carName);

        for (int i = 0; i < 5; i++) {
            carList.printExecuteCarsMove();
        }

        Assertions.assertThat(carList.printWinnerList()).isNotEmpty();
    }
}