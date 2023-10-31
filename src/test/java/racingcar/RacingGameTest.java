package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class RacingGameTest {
  @Test
  public void 자동차_경주_우승자_테스트() {
    List<String> carNames = Arrays.asList("dog", "cat", "tiger");
    RacingGame racingGame = new RacingGame(carNames, 5);
    racingGame.race();
    List<String> winners = racingGame.getWinners();
    assertTrue(winners.contains("dog") || winners.contains("cat") || winners.contains("tiger"));
  }
}
