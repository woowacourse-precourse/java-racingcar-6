package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarControllerTest {
    private final OutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("게임의 전체적인 컨트롤러를 테스트 합니다.")
    void 게임_전체_테스트() {
        String[] args = {"pobi,woni", "1"};
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        RacingCarController.create();

        String actual = outputStream.toString().trim();
        assertThat(actual).contains("pobi", "woni", "최종 우승자");
    }
}