package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingProcess {

  public static final int MOVE_FORWARD_NUMBER = 4;

  public static void goForwardRandom(Car car) {
    int randomNumber = Randoms.pickNumberInRange(0, 9);
    if (randomNumber >= MOVE_FORWARD_NUMBER) {
      car.move();
    }
  }

  public String makingStatusBar(Car car) {
    String progressBar = " : ";
    for (int i = 0; i < car.getProgress(); i++) {
      progressBar += "-";
    }
    return (car.getName() + progressBar);
  }

  public void doRace(int rounds, List<Car> carLineUp) {
    System.out.println("\n실행 결과");
    for (int i = 0; i < rounds; i++) {
      for (int j = 0; j < carLineUp.size(); j++) {
        Car car = carLineUp.get(j);
        goForwardRandom(car);
        UserConsole.printRaceStatus(makingStatusBar(car));
      }
      System.out.println(" ");
    }
  }
}

