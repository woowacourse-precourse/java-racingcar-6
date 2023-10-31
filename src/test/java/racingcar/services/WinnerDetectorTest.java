package racingcar.services;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerDetectorTest {


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
    @DisplayName("모든 우승자 테스트")
    void printAllTest() throws Exception{
        //given
        String expect = "최종 우승자 : dd, work, hello";
        RaceGameState state = new RaceGameState("hello,work,dd");
        //when
        WinnerDetector.printAllWinners(state);
        //then
        String actual = outputStream.toString().substring(0, outputStream.toString().length() - 2);
        Assertions.assertThat(actual).isEqualTo(expect);
     }

}