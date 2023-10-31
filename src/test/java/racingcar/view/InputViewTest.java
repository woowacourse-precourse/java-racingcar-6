package racingcar.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class InputViewTest {

    @Test
    void inputCarName_빈_입력값일_경우_에러() {
        //given
        String input = "";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.validInputBlank(input);
        });
    }

    @Test
    void inputCarName_이름이_중복될_경우_에러() {
        //given
        ArrayList<String> carNames = new ArrayList<>(List.of("pobi", "woni", "jun", "jun"));
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.validCarsDuplicate(carNames);
        });
    }

    @Test
    void inputCarName_자동차_이름_5글자_이상일_경우_에러() {
        //given
        ArrayList<String> carNames = new ArrayList<>(List.of("pobi", "woni", "junnnn"));
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.validCarNameLength(carNames);
        });
    }

    @Test
    void inputCarName_자동차_이름에_공백이_포함된_경우_에러() {
        //given
        ArrayList<String> carNames = new ArrayList<>(List.of("pobi", "woni", "jun"));
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.validCarNameBlank(carNames);
        });
    }

    @Test
    void inputGameRound_정수가_아닐_경우_에러() {
        //given
        String input = "다섯";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.validInputGameRound(input);
        });
    }

    @Test
    void inputGameRound_1미만일_경우_에러() {
    }
}