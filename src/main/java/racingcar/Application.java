package racingcar;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.domain.Judgement;
import racingcar.domain.RacingProcess;
import racingcar.domain.UserConsole;

public class Application {
    public static void main(String[] args) {
        Judgement judgement = new Judgement();
        UserConsole userConsole = new UserConsole();
        RacingProcess race = new RacingProcess();

        ArrayList<Car> carList = userConsole.makingCarList();
        int rounds = userConsole.askRounds();

        System.out.println("\n실행 결과");
        race.doRace(rounds, carList);

        String winner = judgement.judgeWinner(carList);
        System.out.println("최종 우승자 : " + winner);
    }
}
