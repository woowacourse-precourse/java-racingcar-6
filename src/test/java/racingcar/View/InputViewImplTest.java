package racingcar.View;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewImplTest {

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void inputCarNameTest() {
        //given
        String testCarNames = "test1,test2,test3";
        System.setIn(new ByteArrayInputStream(testCarNames.getBytes()));
        InputViewImpl inputViewImpl = new InputViewImpl();

        //when
        String result = inputViewImpl.getCarName();

        //then
        assertEquals("test1,test2,test3", result);
    }

    @Test
    @DisplayName("라운드 횟수 입력 테스트")
    void inputNumberOfRoundTest() {
        //given
        String testNumberOfRound = "5";
        System.setIn(new ByteArrayInputStream(testNumberOfRound.getBytes()));
        InputViewImpl inputViewImpl = new InputViewImpl();

        //when
        String result = inputViewImpl.getNumberOfRound();

        //then
        assertEquals("5", result);
    }
}