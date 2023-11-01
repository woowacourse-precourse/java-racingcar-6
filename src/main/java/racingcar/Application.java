package racingcar;

import racingcar.service.AwardService;
import racingcar.service.GarageService;
import racingcar.service.RacingService;
import racingcar.view.console.ApplicationConsoleView;

public class Application {

  public static void main(String[] args) {

    new RacingGameManager(
        new ApplicationConsoleView(),
        new GarageService(),
        new RacingService(),
        new AwardService()
    ).run();
  }
}
