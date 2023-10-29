package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class InputViewTest {
    Scanner scanner = new Scanner(System.in);

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "lion,cat,dog";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        String[] expectedResult = new String[]{"lion", "cat", "dog"};

        assertThat(InputView.readCarNames()).containsExactly(expectedResult);
    }
}