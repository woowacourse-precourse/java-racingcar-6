package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class RaceControllerTest {
    private final RaceController raceController = new RaceController();

    @Test
    void controller는_자동차_경주_게임의_전반적인_흐름을_다룬다() {
        // given
        System.setIn(createInputStream("pobi,woni,jun\n5"));
        OutputStream output = createOutputStream();
        System.setOut(new PrintStream(output));

        // when
        raceController.startGame();

        // then
        assertThat(output.toString()).contains("실행 결과", "pobi : ", "woni : ", "jun : ", "최종 우승자 : ");
    }

    private InputStream createInputStream(String inputValue) {
        return new ByteArrayInputStream(inputValue.getBytes());
    }

    private OutputStream createOutputStream() {
        return new ByteArrayOutputStream();
    }
}