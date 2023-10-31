package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class RaceViewTest {
    private RaceView raceView = new RaceView();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 사용자는_쉼표를_기준으로_구분되는_자동차_이름들을_입력한다() {
        // given
        System.setIn(createInputStream("pobi,woni,jun"));

        // when, then
        assertThat(raceView.inputNames()).isEqualTo("pobi,woni,jun");
    }

    @Test
    void 사용자는_자동차_경주를_시도할_횟수를_입력한다() {
        // given
        System.setIn(createInputStream("5"));

        // when, then
        assertThat(raceView.inputRaceRound()).isEqualTo(5);
    }

    private InputStream createInputStream(String inputValue) {
        return new ByteArrayInputStream(inputValue.getBytes());
    }

    @Test
    void view는_사용자에게_실행_결과_메시지를_출력해야_한다() {
        // given
        OutputStream output = createOutputStream();
        System.setOut(new PrintStream(output));

        // when
        raceView.outputRacingResults();

        // then
        assertThat(output.toString()).isEqualTo("\n실행 결과\n");
    }

    @Test
    void view는_사용자에게_자동차들의_경주_과정을_출력해야_한다() {
        // given
        String status = "pobi : -\nwoni : -\njun : -";
        OutputStream output = createOutputStream();
        System.setOut(new PrintStream(output));

        // when
        raceView.outputRacingStatus(status);

        // then
        assertThat(output.toString()).isEqualTo("pobi : -\nwoni : -\njun : -\n");
    }

    @Test
    void view는_사용자에게_자동차_경주의_최종_우승자를_출력해야_한다() {
        // given
        String winners = "pobi, woni";
        OutputStream output = createOutputStream();
        System.setOut(new PrintStream(output));

        // when
        raceView.outputRaceWinner(winners);

        // then
        assertThat(output.toString()).isEqualTo("최종 우승자 : pobi, woni\n");
    }

    private OutputStream createOutputStream() {
        return new ByteArrayOutputStream();
    }

}