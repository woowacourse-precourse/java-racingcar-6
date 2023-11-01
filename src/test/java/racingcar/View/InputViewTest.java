package racingcar.View;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {
    static InputView inputView = new InputView();

    @AfterEach
    void cleanUp() {
        Console.close();
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:pobi:1", "pobi,woni:pobi:2"}, delimiter = ':')
    void 차_이름_받기(String input, String expected, int inputSize) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<String> result = inputView.getCarsName();
        assertThat(result.size() == inputSize);
        assertThat(result.get(0).equals(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"4,4", "0,0"})
    void 스테이지_개수_받기(String input, int expected) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int result = inputView.getStageNumber();
        assertThat(result == expected);
    }

}