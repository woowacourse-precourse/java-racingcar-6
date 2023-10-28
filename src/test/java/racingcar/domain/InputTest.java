package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
    Input input = new Input();

    @AfterEach
    void clearSystemIn() {
        Console.close();
    }

    @Test
    void getCarNames_메소드_사용시_유저의_입력을_문자열_리스트로_반환() {

        String userInput = "abc,defgh";

        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());

        System.setIn(inputStream);

        List<String> carNames = input.getCarNames();

        assertThat(carNames).isEqualTo(Arrays.asList("abc", "defgh"));

    }

    @Test
    void getGameCount_메소드_사용시_유저의_입력을_정수로_반환() {
        String userInput = "12";

        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());

        System.setIn(inputStream);

        int gameCount = input.getGameCount();

        assertThat(gameCount).isEqualTo(12);

    }

}
