package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.AwardService;
import racingcar.service.GarageService;
import racingcar.service.RacingService;
import racingcar.view.console.ApplicationConsoleView;

public class RacingGameManager implements Runnable {

  private final ApplicationConsoleView console;
  private final GarageService garageService;
  private final RacingService racingService;
  private final AwardService awardService;

  public RacingGameManager(ApplicationConsoleView console, GarageService garageService,
      RacingService racingService, AwardService awardService) {
    this.console = console;
    this.garageService = garageService;
    this.racingService = racingService;
    this.awardService = awardService;
  }

  @Override
  public void run() {
    // 1. 자동차 이름 입력받기
    saveCarNames();

    // 2. 경주 횟수 입력받기
    int attempt = inputRaceAttempt();

    // 3. 자동차 경주하기
    List<Car> cars = race(attempt);

    // 4. 최종 우승자 출력하기
    getFinalWinners(cars);
  }

  private void saveCarNames() {
    console.printCarNamesInputMessage();
    String carNames = console.getCarNames();
    Arrays.stream(carNames.split(","))
        .forEach(carName -> garageService.save(new Car(carName)));
  }

  private int inputRaceAttempt() {
    console.printAttemptInputMessage();
    return console.getAttempt();
  }

  private List<Car> race(int attempt) {
    List<Car> cars = garageService.findAll();
    console.printResultMessage();

    for (int i = 0; i < attempt; i++) {
      racingService.race(cars, console);
    }

    return cars;
  }

  private void getFinalWinners(List<Car> finalCars) {
    List<String> finalWinners = awardService.getFinalWinners(finalCars);
    console.printFinalWinners(finalWinners);
  }
}

