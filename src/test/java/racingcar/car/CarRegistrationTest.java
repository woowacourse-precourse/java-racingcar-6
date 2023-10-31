package racingcar.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarRegistrationTest {

    @Test
    void 자동차_이름_입력_최대글자초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new CarRegistration("overSix"));
    }

    @Test
    void 자동차_이름_입력_최대글자초과_다중입력_예외처리() {
        assertThrows(IllegalArgumentException.class,
                () -> new CarRegistration("overSix,overSix,overSix,overSix,overSix,overSix"));
    }

    @Test
    void 자동차_등록_입력_최소_미만_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new CarRegistration("only"));
    }


    @Test
    void 자동차_이름_공백_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new CarRegistration(",,,"));
    }

    @Test
    void 자동차_이름_NULL_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new CarRegistration(null));
    }

    @Test
    void 자동차_이름_부분_공백_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new CarRegistration("c,,b,"));
    }

    @Test
    void 자동차_이름_정상_입력() {
        CarRegistration carRegistration = new CarRegistration("a,b,c,d");

        assertEquals(4, carRegistration.getList().size());
        assertEquals("a", carRegistration.getList().get(0).getName());
        assertEquals("b", carRegistration.getList().get(1).getName());
        assertEquals("c", carRegistration.getList().get(2).getName());
        assertEquals("d", carRegistration.getList().get(3).getName());
    }

}