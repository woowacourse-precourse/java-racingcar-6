package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

  private final OutputView outputView;
  private final InputView inputView;
  private Cars racingCars;
  private int gameCount;

  public GameController() {
    this.outputView = new OutputView();
    this.inputView = new InputView();
  }

  public void run() {
    initializeGame();
    startGame();
    endGame();
  }

  private void initializeGame() {
    outputView.displayCarName();
    List<String> nameList = inputView.getCarName();
    outputView.displayGameCount();
    gameCount = inputView.getCount();
    racingCars = new Cars(nameList);
  }

  private void startGame() {
    outputView.displayStart();
    while (gameCount != 0) {
      gameCount--;
      racingCars.moveCars();
      outputView.displayMovement(racingCars.getCarList());
    }
  }

  private void endGame() {
    List<String> winnerList = racingCars.getWinnerList();
    outputView.displayWinner(winnerList);
  }
}