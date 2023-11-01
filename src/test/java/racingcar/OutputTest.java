package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    @Test //4번 기능 테스트
    void printGuideCarName() {
        Output.printGuideCarName();
        String expectedOutput = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test //4번 기능 테스트
    void printGuideTryCount() {
        Output.printGuideTryCount();
        String expectedOutput = "시도할 회수는 몇회인가요?";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

}