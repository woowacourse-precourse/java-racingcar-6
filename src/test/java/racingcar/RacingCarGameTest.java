package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Player;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    //자동차 이름 중복 예외
    @Test
    void validateDuplicatePlayerTest(){
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");

        racingCarGame.players.add(player1);
        racingCarGame.players.add(player2);

        Player player3 = new Player("player1");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> racingCarGame.validateDuplicatePlayer(player3));
        assertThat(e.getMessage()).isEqualTo("회원 이름이 중복되었습니다.");
    }

    @Test
    void noCommaTest() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }
}