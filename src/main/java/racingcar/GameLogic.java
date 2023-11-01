package racingcar;

import java.util.Map.Entry;
import camp.nextstep.edu.missionutils.Randoms;

public class GameLogic {
  public InputOutput io = new InputOutput();
  public Cars racecars = new Cars();
  public Integer trialCount = 0;

  public void startGame() {
    setupGame();
    raceLogic();
    winnerLogic();
  }

  public void raceLogic() {
    io.printResultStatement();
    for (int i = GameConstant.ZERO; i < trialCount; i++) {
      processTurn();
      io.printCars(racecars.getCars());
    }
  }

  public void processTurn() {
    for (Entry<String,Integer> car : racecars.getCars()) {
      processCar(car);
    }
  }

  public void processCar(Entry<String,Integer> car) {
    if (runSuccess()) {
      racecars.moveCar(car);
    }
  }

  public void winnerLogic() {
    Integer leadPosition = GameConstant.STARTPOSITION;
    for (Entry<String,Integer> car : racecars.getCars()) {
      if (car.getValue() > leadPosition) {
        leadPosition = car.getValue();
      }
    }
    io.printWinners(racecars.getCars(), leadPosition);
  }

  public void setupGame() {
    setupCars();
    setupTrialCount();
  }

  public void setupCars() {
    String[] carNames = io.getCarNames();
    for (String carName : carNames) {
      racecars.addCar(carName);
    }
  }

  public void setupTrialCount() {
    trialCount = io.getTrialCount();
  }

  public boolean runSuccess() {
    int roll = Randoms.pickNumberInRange(0,9);
    return roll >= 4;
  }

}
