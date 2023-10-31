package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Player;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    RacingCarGame racingCarGame = new RacingCarGame();

    //구분자로 String 나누기 확인
    @Test
    void inputCarName() {
         String input = "1,2";
         String[] result = input.split(",");

         assertThat(result).contains("2", "1");
         assertThat(result).containsExactly("1", "2");
    }
    
}