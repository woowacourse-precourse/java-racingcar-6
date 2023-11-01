package test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    void 경주_자동차이름_반점_기준으로_구분() {
        String input = "pobi,woni,jun";
        String[] lst = generateRacersFromNames(input);

        assertThat(lst).isEqualTo(new String[]{"pobi", "woni", "jun"});
    }

    private String[] generateRacersFromNames(String input) {
        return input.split(",");
    }

}
