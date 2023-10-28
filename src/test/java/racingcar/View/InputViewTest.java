package racingcar.View;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.View.InputView.getCarName;
import static racingcar.View.InputView.getNumberOfRound;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void inputCarNameTest() {
        //given
        String testCarNames = "test1,test2,test3";
        System.setIn(new ByteArrayInputStream(testCarNames.getBytes()));

        //when
        String result = getCarName();

        //then
        assertEquals("test1,test2,test3", result);
    }

    @Test
    @DisplayName("라운드 횟수 입력 테스트")
    void inputNumberOfRoundTest() {
        //given
        String testNumberOfRound = "5";
        System.setIn(new ByteArrayInputStream(testNumberOfRound.getBytes()));

        //when
        String result = getNumberOfRound();

        //then
        assertEquals("5", result);
    }
}