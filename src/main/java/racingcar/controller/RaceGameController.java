package racingcar.controller;

import racingcar.service.RaceGameService;
import racingcar.view.InputView;

public class RaceGameController {

  private final InputView inputView = new InputView();
  private final RaceGameService raceGameService = new RaceGameService();

  public void StartRaceGame() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String[] carNames = inputView.readCarName().split(",");
    raceGameService.initializeCars(carNames);

  }

  public void EndRaceGame() {
    System.out.println("게임을 종료합니다.");
  }
}
