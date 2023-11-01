package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingGameTest {

    private ByteArrayOutputStream output;
    private InputStream input;

    @BeforeEach
    void setUp() {
        // 테스트 전에 표준 출력 및 입력을 모의 데이터로 대체하는 설정
        output = new ByteArrayOutputStream();
        input = System.in;
        System.setOut(new PrintStream(output));
    }

    @Test
    void playGame_ShouldThrowExceptionForInvalidCarName() {
        // 유효하지 않은 자동차 이름 입력으로 예외 확인
        String inputString = "pobi,woni,javaji\n5\n";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));

        assertThatThrownBy(() -> CarRacingGameRunner.runCarRacingGame())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
