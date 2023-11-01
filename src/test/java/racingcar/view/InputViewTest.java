package racingcar.view;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    private final InputView inputView = new InputView();

    @Test
    void extractAndValidateCarNames() {
        List<String> strings = inputView.extractAndValidateCarNames("car, car2");
        assertThat(strings.size()).isEqualTo(2);
        assertThat(strings).contains("car", "car2");
    }

    @Test
    void extractAndValidateRepeatCount() {
        int repeatCount = inputView.extractAndValidateRepeatCount("3");
        assertThat(repeatCount).isEqualTo(3);
    }

}