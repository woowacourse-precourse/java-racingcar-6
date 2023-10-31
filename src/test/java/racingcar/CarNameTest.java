package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.car.model.CarName;

class CarNameTest {
    @Test
    void 자동차_이름_입력_최대글자초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new CarName("overSix"));
    }

    @Test
    void 자동차_이름_입력_공백_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(""));
    }

    @Test
    void 자동차_이름_입력_null_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(null));
    }


    @Test
    void 자동차_이름_정상입력() {
        assertDoesNotThrow(() -> new CarName("pobi"));
    }

    @Test
    void 자동차_이름_입력_확인() {
        String pobi = "pobi";
        CarName pobiCar = new CarName(pobi);
        assertEquals(pobi, pobiCar.getName());
    }

}