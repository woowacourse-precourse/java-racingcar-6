package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest {

    @Test
    public void 쉼표로_주어진_값을_구분하여_공백이_없는_List로_반환() {
        InputView inputView = new InputView();

        String inputValue = "  하나  , 둘  ,  셋  ";
        InputStream inputStream = new ByteArrayInputStream(inputValue.getBytes());
        System.setIn(inputStream);

        List<String> result = inputView.readNamesOfCars();
        List<String> expected = List.of("하나", "둘", "셋");
        assertEquals(expected, result);
    }


}
