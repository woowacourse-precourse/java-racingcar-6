package racingcar.View;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Global.Constants;

class OutputViewTest {

    static OutputView outputView = new OutputView();

    @Test
    void 각_스테이지_결과_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Map<String, Integer> result = new HashMap<>();
        result.put("pobi", 1);
        outputView.printEachStageResult(result);
        assertThat(out.toString().contains("pobi : - "));
    }

    @Test
    void 출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        outputView.printString(Constants.getCarsNameState);
        assertThat(out.toString().contains(Constants.getCarsNameState));
    }


    @ParameterizedTest
    @CsvSource(value = {"\"pobi\",\"woni\"-최종 우승자 : pobi, woni", "\"pobi\"-최종 우승자 : pobi"}, delimiter = '-')
    void 우승자_출력(String input, String expected) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        outputView.printWinner(List.of(input));
        assertThat(out.toString().contains(expected));
    }

}