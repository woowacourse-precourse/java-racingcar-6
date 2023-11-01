package racingcar;

import java.util.ArrayList;
import java.util.Collections;
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
    List<String> cars = inputView.carName();
    int trialNum = inputView.trialNum();
    List<Integer> locations = new ArrayList<>(Collections.nCopies(cars.size(), 0));
    System.out.println("\n실행 결과");
    while (trialNum > 0) {
      locations = racingcarGame.evaluateTrial(locations, racingcarRandomNumber.generate(cars.size()));
      outputView.printTrial(cars, locations);
      trialNum--;
    }
  }
}
