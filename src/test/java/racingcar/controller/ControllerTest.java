package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @DisplayName("자동차 이름 예외 처리 확인")
    @Test
    void 자동차_이름_예외_처리_확인() {

        Game game = new Game();

        assertThrows(IllegalArgumentException.class, () -> {
            game.setCar("가,가");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.setCar("가,,가");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.setCar("가,다,");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.setCar("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.setCar("가나다라마");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.setCar("가나다라마바사, 아자");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.setCar("간ㄴ, 아자");
        });

    }
    
    @DisplayName("Game 객체에 정상적으로 Car정보가 저장되는지 확인")
    @Test
    void Game_객체_Car_이름_확인() {
        String[] carNames = {"가나", "다라"};

        String carNameListString = carNames[0] + "," + carNames[1];

        Game game = new Game();
        game.setCar(carNameListString);

        for (int i = 0; i < game.getCarList().size(); i++) {
            assertEquals(carNames[i], game.getCarList().get(i).getName());
        }

    }

}