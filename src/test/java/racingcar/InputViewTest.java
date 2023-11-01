package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.util.CarNameValidator;
import racingcar.util.CommonValidator;
import racingcar.util.GameRoundValidator;

import java.util.ArrayList;
import java.util.List;

class InputViewTest {

    @Test
    void 빈_입력값일_경우_에러() {
        //given
        String input = "";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CommonValidator.validInputBlank(input);
        });
    }

    @Test
    void 자동차_이름이_중복될_경우_에러() {
        //given
        ArrayList<String> carNames = new ArrayList<>(List.of("pobi", "woni", "jun", "jun"));
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validInputCarName(carNames);
        });
    }

    @Test
    void 자동차_이름_5글자_이상일_경우_에러() {
        //given
        ArrayList<String> carNames = new ArrayList<>(List.of("pobi", "woni", "junnnn"));
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validInputCarName(carNames);
        });
    }

    @Test
    void 자동차_이름에_공백이_포함된_경우_에러() {
        //given
        ArrayList<String> carNames = new ArrayList<>(List.of("po bi", "woni", "jun"));
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validInputCarName(carNames);
        });
    }
    @Test
    void GameRound_정수가_아닐_경우_에러() {
        //given
        String input = "다섯";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            GameRoundValidator.validInputGameRound(input);
        });
    }

    @Test
    void GameRound_1미만일_경우_에러() {
        //given
        String input = "0";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            GameRoundValidator.validInputGameRound(input);
        });
    }
}