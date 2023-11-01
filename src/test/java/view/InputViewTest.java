package view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    private final InputStream systemIn = System.in;

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    void restoreSystemInputOutput() {
        System.setIn(systemIn);
        Console.close();
    }

    @Test
    public void requestInputCarNames_사용자_입력을_받아서_String_반환() throws Exception {
        //given
        String input = "pobi,woni";

        //when
        provideInput(input);
        String result = InputView.requestInputCarNames();

        //then
        assertThat(result).isEqualTo(input);
    }

    @Test
    public void requestInputCarNames_사용자_입력이_없을_경우_예외_발생() throws Exception {
        //given
        String input = "\n";

        //when
        provideInput(input);

        //then
        assertThrows(IllegalArgumentException.class, () -> InputView.requestInputCarNames());
    }

    @Test
    public void requestInputTryCount_사용자_입력을_받아서_String_반환() throws Exception {
        //given
        String input = "5";

        //when
        provideInput(input);

        //then
        assertThat(InputView.requestInputTryCount()).isEqualTo(input);
    }

    @Test
    public void requestInputTryCount_사용자_입력이_없을_경우_예외_발생() throws Exception {
        //given
        String input = "\n";

        //when
        provideInput(input);

        //then
        assertThrows(IllegalArgumentException.class, () -> InputView.requestInputTryCount());
    }
}
