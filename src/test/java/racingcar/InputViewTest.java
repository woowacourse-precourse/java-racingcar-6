package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest {

    void systemIn(final String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        System.setIn(null);
    }

    @Test
    public void 쉼표로_주어진_값을_구분하여_공백이_없는_List로_반환() {
        InputView inputView = new InputView();

        String inputValue = "  하나  , 둘  ,  셋  ";
        systemIn(inputValue);

        List<String> result = inputView.readNamesOfCars();
        List<String> expected = List.of("하나", "둘", "셋");
        assertEquals(expected, result);
    }

    @Test
    public void 시도_횟수가_숫자가_아닌_경우_예외를_반환() {
        InputView inputView = new InputView();

        String inputValue = "radom_string";
        systemIn(inputValue);

        assertThrows(IllegalArgumentException.class, inputView::readTrialNumber);
    }

}
