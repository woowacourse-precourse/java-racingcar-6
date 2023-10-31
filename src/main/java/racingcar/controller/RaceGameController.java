package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RaceGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {

  private final InputView inputView = new InputView();
  private final RaceGameService raceGameService = new RaceGameService();
  private final OutputView outputView = new OutputView();

  public void StartRaceGame() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String[] carNames = inputView.readCarName().split(",");
    raceGameService.initializeCars(carNames);

    System.out.println("시도할 횟수는 몇회인가요?");
    int round = inputView.readProgressCount();
    System.out.println(round);

    for (int i = 0; i <round ; i++) {
        raceGameService.race();
        outputView.printRaceResult();
    }
    String winners = raceGameService.getWinners();
    outputView.printGameWon(winners);
  }

  public void EndRaceGame() {
    System.out.println("게임을 종료합니다.");
  }
}
