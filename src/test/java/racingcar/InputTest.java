package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {
    Input input;

    @BeforeEach()
    void setUp(){
        input = new Input();
    }
    @Test
    @DisplayName("플레이어 이름 리스트로 변환 확인")
    void 입력한_문자열_리스트로_변환(){
        //given
        String testName="pobi,woni,jun";
        ArrayList testList = new ArrayList(Arrays.asList("pobi","woni","jun"));
        //when
        input.setPlayerName(testName);
        //then
        Assertions.assertEquals(input.getPlayerName(),testList);
    }
    @Test
    @DisplayName("플레이어이름 5글자 초과 검증")
    void 입력한_이름_5글자초과_확인(){
        //given
        String testName="Tigers,woni,jun";
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //when
            input.setPlayerName(testName);
        });
    }
}
