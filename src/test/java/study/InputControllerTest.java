package study;

import org.junit.jupiter.api.Test;
import racingcar.Controller.InputController;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputControllerTest {

    @Test
    void 빈_이름에_대한_예외_처리_() {
        InputController inputController = new InputController();
        assertThrows(IllegalArgumentException.class, () -> {
            inputController.splitName("");
        });
    }

    @Test
    void 없는_이름에_대한_예외_처리() {
        InputController inputController = new InputController();
        assertThrows(IllegalArgumentException.class, () -> {
            inputController.splitName(",,,");
        });
    }
}