package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class RacingGameTest {
  @Test
  public void 자동차_경주_우승자_테스트() {
    List<String> carNames = Arrays.asList("pobi", "woni", "jun");
    RacingGame racingGame = new RacingGame(carNames, 5);
    racingGame.race();
    List<String> winners = racingGame.getWinners();
    assertTrue(winners.contains("pobi") || winners.contains("woni") || winners.contains("jun"));
  }
}
