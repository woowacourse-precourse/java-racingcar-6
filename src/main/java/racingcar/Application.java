package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.getWinners.GetWinnersImpl;
import racingcar.race.RaceImpl;

public class Application {
    public static void main(String[] args) {
        String[] carNames = Console.readLine().split(",");

        int rounds = Integer.parseInt(Console.readLine());

        try {
            RaceImpl race = new RaceImpl(carNames);
            GetWinnersImpl getWinners = new GetWinnersImpl(race);
            race.start(rounds);

            System.out.println("최종 우승자 : " + String.join(", ", getWinners.getWinners()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
