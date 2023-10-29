package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @Test
    void inputCarName() {
         String input = "1,2";
         String[] result = input.split(",");

         assertThat(result).contains("2", "1");
         assertThat(result).containsExactly("1", "2");
    }

}