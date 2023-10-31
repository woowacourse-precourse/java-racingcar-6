package racingcar.domain.broadcast;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

class BroadcastTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void broadcasting() {
        HashMap<String, Integer> lineUp = new HashMap<>(){{
            put("hi", 0);
            put("my", 1);
            put("name", 2);
            put("is", 1);
            put("Hello", 2);
            put("world", 3);
        }};

        // 캡처 시작
        ByteArrayOutputStream captureOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captureOutput));

        Broadcast.broadcasting(lineUp);

        // 캡처한 출력 문자열
        String capturedOutput = captureOutput.toString();

        // 복원
        System.setOut(originalOut);

        // 예상한 출력 문자열 생성
        StringBuilder expectedOutput = new StringBuilder();
        for (Map.Entry<String, Integer> entry : lineUp.entrySet()) {
            expectedOutput.append(entry.getKey()).append(" : ");
            for (int i = 0; i < entry.getValue(); i++) {
                expectedOutput.append("-");
            }
            expectedOutput.append("\n");
        }

        // 캡처한 출력 문자열과 예상 출력 문자열 비교
        Assertions.assertThat(capturedOutput).isEqualTo(expectedOutput.toString());

        // 아무리 봐도 문제가 없는데 통과가 안되는 이유를 모르겠네요
    }

    @Test
    void prizeCeremony() {
        HashMap<String, Integer> lineUp = new HashMap<>(){{
            put("hi",0);
            put("my",1);
            put("name",2);
            put("is",1);
            put("Hello",3);
            put("world",3);
        }};

        Broadcast.prizeCeremony(lineUp);

        Assertions.assertThat(outContent.toString().trim()).isEqualTo("world, Hello");
    }

    // 원래 System.out 원복
    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }
}