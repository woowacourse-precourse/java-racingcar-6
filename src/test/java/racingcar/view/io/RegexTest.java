package racingcar.view.io;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RegexTest {
    @ParameterizedTest(name = "{0}은 잘못된 입력이다.")
    @ValueSource(strings = {"1,2,3,4,", "1,,2,3,4", ",1,2,3"})
    void failTest(String input) {
        String[] tokens = input.split(",");
        for (String token : tokens) {
            System.out.println("\"" + token + "\"");
        }
    }
}