package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RegistrationTest {

    @Test
    void getCarNames_메서드가_문자열을_받아_쉼표를_기준으로_자동차_이름들을_분리() {
        String input = "po bi,woni, jun";
        Registration registration = new Registration();

        String[] actual = registration.getCarNames(input);

        assertThat(actual).containsExactly("po bi", "woni", " jun");
    }

}
