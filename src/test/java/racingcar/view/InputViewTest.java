package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 자동차이름_입력() {
        String input = "차1, 차2, 차3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        List<String> cars = inputView.getCarNames();
        for (String car : cars) {
            System.out.println(car);
        }
    }
}