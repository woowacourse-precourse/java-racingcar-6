package racingcar;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ApplicationTest {

    @Test
    void 경주_게임_테스트() {
        // 표준 출력 대체
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // 표준 입력 대체
        System.setIn(new ByteArrayInputStream("pobi,woni\n5\n".getBytes()));

        // 게임 실행
        Application.main(new String[] {});

        // 결과 검증
        String outputText = output.toString();
        assertThat(outputText).contains("실행 결과");
        assertThat(outputText).contains("최종 우승자");
    }
}

