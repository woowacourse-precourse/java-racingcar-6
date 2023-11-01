package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("getCarNameList must be success")
    @Test
    void getCarNameListMustBeSuccess() {
        String input = "pobi,woni,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> result = inputView.getCarNameList();

        assertThat(result).isEqualTo(Arrays.asList("pobi", "woni", "jun"));
    }

    @DisplayName("getRoundTime must be fail when input is not Integer type")
    @Test
    void getRoundTimeMustBeFail() {
        String input = "A";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.getRoundTime())
                .isInstanceOf(IllegalArgumentException.class);
    }

}
