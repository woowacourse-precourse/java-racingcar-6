package util;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputTest {
    @Test
    void 사용자에게서_숫자_입력_받기() {
        InputView inputView = new InputView();
        assertThat(inputView.getUserInput()).isEqualTo("123");
    }

    public class InputView {
        public String getUserInput() {
            InputStream in = generateUserInput("123");
            System.setIn(in);
            Scanner sc = new Scanner(System.in);

            return sc.next();
        }

        public static InputStream generateUserInput(String input) {
            return new ByteArrayInputStream(input.getBytes());
        }
    }
}
