package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> carNames = InputFactory.getCars(Console.readLine());
        int racingRound = InputFactory.getRacingRound(Console.readLine());

        Race race = new Race(carNames, racingRound);
        race.start();

        ResultView.printWinners(race.getCars());
    }
}
