package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Judgement;
import racingcar.domain.RacingProcess;
import racingcar.domain.UserConsole;


public class Application {

  public static void main(String[] args) {
    Judgement judgement = new Judgement();
    UserConsole userConsole = new UserConsole();
    RacingProcess race = new RacingProcess();
    List<Car> carLineUp = userConsole.makingCarLineUp();
    int rounds = userConsole.askRounds();
    race.doRace(rounds, carLineUp);
    List<String> winners = judgement.judgeWinner(carLineUp);
    UserConsole.printWinners(winners);
  }
}
