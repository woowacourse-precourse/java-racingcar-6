package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    private RacingCarGame racingCarGame;
    private ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        racingCarGame = new RacingCarGame();
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @Test
    @DisplayName("공동 우승이 있는 경우")
    void jointWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    System.setIn(new ByteArrayInputStream("요환,동민,민규\n3".getBytes()));
                    racingCarGame.run();
                    assertThat(outputMessage.toString())
                            .contains("요환 : ---")
                            .contains("민규 : ---")
                            .contains("최종 우승자 : 요환, 민규");
                }, 4, 3, 4, 4, 3, 4, 4, 3, 4
        );
    }
}