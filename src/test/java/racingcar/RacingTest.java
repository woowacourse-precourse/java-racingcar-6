package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {
    Racing racing = new Racing();;
    @BeforeEach
    void setUp(){
        racing.input.setPlayerName("pobi,woni,jun");
        racing.input.setRound(5);
    }
    @Test
    @DisplayName("레이싱 초기 세팅확인")
    void 레이싱_초기_세팅값_0_확인(){
        //given
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(0,0,0));
        //when
        racing.setPlayerResult();
        //then
        Assertions.assertEquals(racing.getPlayerResult(),testList);
    }
    @Test
    @DisplayName("레이싱 진행 확인")
    void 결과에_따른_레이싱_진행_확인(){
        //given
        boolean move = true;
        int testPlayer = 0;
        ArrayList<Integer> testList =
                new ArrayList<>(Arrays.asList(1,0,0));
        //when
        racing.setPlayerResult();
        racing.movePlayer(move,0);
        //then
        Assertions.assertEquals(racing.getPlayerResult(),testList);
    }

    @Test
    @DisplayName("랜덤으로 뽑은 숫자가 이동을 시키는지 확인")
    void 숫자를_참거짓_반환_확인(){
        //given
        int randomNumber=4;
        boolean testExpect=true;
        //when
        boolean testResult=racing.verifyNumber(randomNumber);
        //then
        Assertions.assertEquals(testResult,testExpect);
    }
    @Test
    @DisplayName("랜덤으로 뽑은 숫자가 이동을 시키는지 확인")
    void 숫자를_참거짓_반환_확인_거짓(){
        //given
        int randomNumber=0;
        boolean testExpect=false;
        //when
        boolean testResult=racing.verifyNumber(randomNumber);
        //then
        Assertions.assertEquals(testResult,testExpect);
    }
}
