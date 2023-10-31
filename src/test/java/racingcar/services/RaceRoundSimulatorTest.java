package racingcar.services;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceRoundSimulatorTest {

    private static ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUpStreams(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void clearStreams(){
        System.setOut(System.out);
    }

    @Test
    @DisplayName("한 라운드를 실행한 결과 누락 없는 지 테스트")
    void executeRoundTest() {
        //given
        String sample = "pobi, woni, kim, lee";
        RaceGameState state = new RaceGameState(sample);
        //when
        RaceRoundSimulator.execute(state);
        //then
        String actualOut = outputStream.toString();
        boolean assertCondition1 = actualOut.contains("pobi") && actualOut.contains("kim");
        boolean assertCondition2 = actualOut.contains("kim") && actualOut.contains("lee");
        Assertions.assertTrue(assertCondition1 && assertCondition2);
     }


}