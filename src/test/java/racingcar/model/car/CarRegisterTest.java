package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRegisterTest {
    @Test
    @DisplayName("자동차 이름 등록 시 준비 여부 검사")
    void 자동차_준비_검사() {
        CarRegister carRegister = new CarRegister();
        carRegister.registerCar("car1");
        carRegister.registerCar("car2");

        assertThat(carRegister.prepareCarList().getCurrentResult().get(0).getName().equals("car1"));
        assertThat(carRegister.prepareCarList().getCurrentResult().get(1).getName().equals("car2"));
    }
}
