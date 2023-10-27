package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputViewTest;

class RacingGameTest {

    RacingGame racingGame = new RacingGame();

    OutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void open() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void close() {
        Console.close();
    }

    @Test
    @DisplayName("반복 횟수가 숫자로 입력되어야 한다.")
    void 횟수_입력_예외() {
        // given
        InputViewTest.systemIn("a,b,c\nG");

        // when
        // then
        assertThatThrownBy(() -> racingGame.run())
                .isInstanceOf(IllegalArgumentException.class);
    }
}