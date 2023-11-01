package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

class InputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    void setInputValues(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("사용자의 자동차 입력을 InputView에서 올바르게 처리한다.")
    @Test
    void readCarName() {
        setInputValues("pobi,woni,jun");
        InputView inputView = new InputView();
        List<String> strings = inputView.readCarName();

        assertThat(strings).containsExactlyInAnyOrderElementsOf(Arrays.asList("pobi", "woni", "jun"));
        assertThat(output.toString().trim()).isEqualTo(CAR_NAMES_INPUT_MESSAGE);
        Console.close();
    }

    @DisplayName("사용자의 라운드 횟수 입력을 InputView에서 올바르게 처리한다.")
    @Test
    void readRaceRound() {
        setInputValues("123");
        InputView inputView = new InputView();
        String coin = inputView.readRaceRound();

        assertThat(coin).isEqualTo("123");
        assertThat(output.toString().trim()).isEqualTo(TRY_COUNT_INPUT_MESSAGE);
        Console.close();
    }
}