package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingcarController {
  private final RacingcarGame racingcarGame;
  private final RacingcarRandomNumber racingcarRandomNumber;
  private final InputView inputView;
  private final OutputView outputView;


  public RacingcarController() {
    racingcarGame = new RacingcarGame();
    racingcarRandomNumber = new RacingcarRandomNumber();
    inputView = new InputView();
    outputView = new OutputView();
  }

  public void playRacingcar() {

  }
}
