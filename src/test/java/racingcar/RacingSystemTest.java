package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingSystemTest {

    @Test
    void 자동차_중복_예외발생() {
        RacingSystem racingSystem = new RacingSystem();
        assertThrows(IllegalArgumentException.class,
                () -> racingSystem.checkValidName("car1,car2,car1"));
    }

    @Test
    void 자동차_길이_예외발생() {
        RacingSystem racingSystem = new RacingSystem();
        assertThrows(IllegalArgumentException.class,
                () -> racingSystem.checkValidName("car123,car2, "));
    }

    @Test
    void 자동차_공백_예외발생() {
        RacingSystem racingSystem = new RacingSystem();
        assertThrows(IllegalArgumentException.class,
                () -> racingSystem.checkValidName("car1,car2, "));
    }

    @Test
    void 올바른_자동차_입력() {
        RacingSystem racingSystem = new RacingSystem();
        assertDoesNotThrow(() -> racingSystem.checkValidName("car1, car2, car3"));
    }
//
//    @Test
//    void 입력_예외발생() {
//        RacingSystem racingSystem = new RacingSystem();
//        assertThrows(IllegalArgumentException.class,
//                () -> racingSystem.checkNumber("3A"));
//    }
//
//    @Test
//    void 올바른_입력_입력() {
//        RacingSystem racingSystem = new RacingSystem();
//        assertDoesNotThrow(() -> racingSystem.checkNumber("3"));
//    }
}