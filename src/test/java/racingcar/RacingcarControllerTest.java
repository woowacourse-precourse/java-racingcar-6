package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingcarControllerTest {
    RacingcarController racingcarController = new RacingcarController();

    @Test
    void 자동차이름_입력값_구분() {
        String inputCarsName = "abc,def,gh";
        String[] result = racingcarController.splitCarsName(inputCarsName);
        assertThat(result).contains("abc", "def", "gh");
    }
}