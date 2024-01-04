package racingcar;

import java.util.*;
import racingcar.domain.Car;
import racingcar.domain.Judgement;
import racingcar.domain.RacingProcess;
import racingcar.domain.UserConsole;


public class Application {
    public static void main(String[] args) {
        Judgement judgement = new Judgement();
        UserConsole userConsole = new UserConsole();
        RacingProcess race = new RacingProcess();
        List<String> winners;

        List<Car> carList = userConsole.makingCarList();
        int rounds = userConsole.askRounds();
        race.doRace(rounds, carList);
        winners = judgement.judgeWinner(carList);
        UserConsole.printWinners(winners);
    }
}
