package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.CarNameRegistration;
import racingcar.car.model.CarName;

class CarNameRegistrationTest {
    @Test
    void 자동차_이름_입력_문자_최소수량부족_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new CarNameRegistration("onlyOneCarWouldFail"));
    }

    @Test
    void 자동차_이름_입력_차량이름_없음_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new CarNameRegistration(",,,,"));
    }

    @Test
    void 자동차_이름_입력_차량이름_NULL_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new CarNameRegistration(null));
    }

    @Test
    void 자동차_이름_입력_차량이름_공백_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new CarNameRegistration("onlyOneCarWouldFail,,,,"));
    }

    @Test
    void 자동차_이름_입력_차량이름_최대수량초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new CarNameRegistration("ford,kia,ferrari"));
    }


    @Test
    void 자동차_이름_입력_차량이름_정상입력() {
        assertDoesNotThrow(() -> new CarNameRegistration("kia,bmw,benz"));
    }

    @Test
    void 자동차_이름_입력_차량이름_get() {

        String inputCarNames = "kia,bmw,benz";
        String[] splitcarNames = inputCarNames.split(",");

        CarNameRegistration carNameRegistration = new CarNameRegistration(inputCarNames);
        List<CarName> carNameList = carNameRegistration.getCarNameList();
        carNameList.forEach(carName -> splitcarNames[carNameList.indexOf(carName)].equals(carName.getName()));
    }

}