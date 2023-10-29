package racingcar.controller;

import racingcar.config.Config;
import racingcar.service.GameService;
import racingcar.view.PrintView;

public class GameController {
  Config config = new Config();
  PrintView printView = new PrintView();
  GameService gameService = new GameService(config);

  public void play() {
    inputProcessing();
    carsProcessing();
    resultProcessing();
  }

  public void inputProcessing() {
    printView.inputCarNameView();
    gameService.getInputCar();
    printView.inputTryNumView();
    gameService.getInputTryNum();
  }

  public void carsProcessing() {
    for(int i=0;i<gameService.tryNum;i++) {
      gameService.carForward();
      printView.carForwardView(gameService.carList);
    }
  }

  public void resultProcessing() {
    gameService.findWinner();
    printView.winnerView(gameService.winnerList);
  }


}
