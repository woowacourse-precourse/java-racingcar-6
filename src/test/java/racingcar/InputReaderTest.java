package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputReaderTest {

    void setInputValues(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("사용자의 자동차 입력을 올바르게 처리한다.")
    @Test
    void racingCar() {
        setInputValues("pobi,woni,jun");
        InputReader inputReader = new InputReader();
        List<String> strings = inputReader.racingCar();

        assertThat(strings).containsExactlyInAnyOrderElementsOf(Arrays.asList("pobi", "woni", "jun"));
        Console.close();
    }

    @DisplayName("사용자의 라운드 횟수 입력을 올바르게 처리한다.")
    @Test
    void raceRound() {
        setInputValues("123");
        InputReader inputReader = new InputReader();
        String coin = inputReader.raceRound();

        assertThat(coin).isEqualTo("123");
        Console.close();
    }
}