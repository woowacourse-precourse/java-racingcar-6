package racingcar.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;
import racingcar.view.InputViewTest;
import racingcar.view.OutputView;

class RacingGameTest {

    RacingGame racingGame = new RacingGame(new InputView(), new OutputView());

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
    @DisplayName("입력만큼 반복되어야 한다.")
    void 반복_횟수_테스트() {
        // given
        int n = 5;
        InputViewTest.systemIn("a,b,c\n" + n);

        // when
        racingGame.run();

        // then
        assertThat(out.toString()).containsPattern("""
                실행 결과
                a : -{0,1}
                b : -{0,1}
                c : -{0,1}

                a : -{0,2}
                b : -{0,2}
                c : -{0,2}

                a : -{0,3}
                b : -{0,3}
                c : -{0,3}

                a : -{0,4}
                b : -{0,4}
                c : -{0,4}

                a : -{0,5}
                b : -{0,5}
                c : -{0,5}

                최종 우승자 :\s""");
    }
}