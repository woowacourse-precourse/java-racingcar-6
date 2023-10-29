package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CensorTest {

    private final Censor censor = new Censor();

    @DisplayName("플레이어가 빈칸을 입력한다면, 예외가 발생한다.")
    @Test
    void playerInputSpace() {
        //given
        String inputNull = null;
        String inputEnter = "";
        String inputSpace = " ";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            censor.checkInputForNickname(inputNull);
            censor.checkInputForNickname(inputEnter);
            censor.checkInputForNickname(inputSpace);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            censor.checkInputForGameTime(inputNull);
            censor.checkInputForGameTime(inputEnter);
            censor.checkInputForGameTime(inputSpace);
        });
    }

    @DisplayName("플레이어가 입력 마지막에 콤마(,)를 입력하거나 콤마(,)만 입력할 경우, 예외가 발생한다.")
    @Test
    void playerInputEndWithComma() {
        //given
        String input = "pobi,";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            censor.checkInputForNickname(input);
        });
    }

    @DisplayName("플레이어가 콤마(,)만 입력한다면, 예외가 발생한다.")
    @Test
    void playerInputOnlyComma() {
        //given
        String input = ",";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            censor.checkInputForNickname(input);
        });
    }

    @DisplayName("플레이어가 입력한 닉네임의 길이가 4자를 초과하면, 예외가 발생한다.")
    @Test
    void playerInputOverLength() {
        //given
        String input = "woowa";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            censor.checkInputForNickname(input);
        });
    }

    @DisplayName("플레이어가 입력한 닉네임이 중복된 값을 가진다면, 예외가 발생한다.")
    @Test
    void playerInputDuplicateNickname() {
        //given
        String input = "pobi,pobi";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            censor.checkInputForNickname(input);
        });
    }

    @DisplayName("플레이어가 입력한 시도 회수가 정수의 형식을 가지고 있지 않는다면, 예외가 발생한다.")
    @Test
    void playerInputGameTimeNotInteger() {
        //given
        String input = "세번";

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            censor.checkInputForGameTime(input);
        });
    }
}