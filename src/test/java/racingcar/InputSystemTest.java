package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputSystemTest {

    private InputSystem inputSystem;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        inputSystem = new InputSystem();
        cars = new ArrayList<>();
    }

    @Test
    void 자동차_이름_입력() {
        assertDoesNotThrow(() -> inputSystem.checkValidName("car1,car2,car3", cars));
    }

    @Test
    void 자동차_중복_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> inputSystem.checkValidName("car1,car2,car1", cars));
    }

    @Test
    void 자동차_길이_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> inputSystem.checkValidName("car123,car2, ", cars));
    }

    @Test
    void 자동차_공백_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> inputSystem.checkValidName("car1,car2,", cars));
    }

    @Test
    void 입력_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> inputSystem.checkNumber("3A"));
    }

    @Test
    void 올바른_입력_입력() {
        assertDoesNotThrow(() -> inputSystem.checkNumber("123"));
    }
}