package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;
import racingcar.service.InitService;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @DisplayName("자동차 이름 예외 처리 확인")
    @Test
    void 자동차_이름_예외_처리_확인() {

        Game game = new Game();

        assertThrows(IllegalArgumentException.class, () -> {
            game.validationCarNameAndSetGame("가,가");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validationCarNameAndSetGame("가,,가");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validationCarNameAndSetGame("가,다,");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validationCarNameAndSetGame("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validationCarNameAndSetGame("가나다라마");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validationCarNameAndSetGame("가나다라마바사, 아자");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validationCarNameAndSetGame("간ㄴ, 아자");
        });

    }

}