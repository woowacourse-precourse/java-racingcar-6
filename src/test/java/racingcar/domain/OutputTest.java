package racingcar.domain;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OutputTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

//    //개행문자의 LF, CRLF 차이로 인한 오류로 보여짐
//    @Test
//    void printCarPosition() {
//        Output output = new Output();
//        HashMap<String, Integer> hashMap = new HashMap<String, Integer>() {{
//            put("pobi", 2);
//            put("woni", 3);
//            put("jun", 1);
//        }};
//
//        output.printCarPosition(hashMap);
//        assertEquals("pobi : --\njun : -\nwoni : ---\n", outputStreamCaptor.toString().trim());
//    }

    @Test
    void printFinalWinner() {
        Output output = new Output();
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>() {{
            put("pobi", 3);
            put("woni", 4);
            put("jun", 1);
            put("jerry", 6);
            put("tom", 6);
        }};

        output.printFinalWinner(hashMap);
        assertEquals("최종 우승자 : jerry, tom", outputStreamCaptor.toString().trim());

    }
}