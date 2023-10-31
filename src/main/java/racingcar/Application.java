package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ResultView.printEnterNameGuide();
        InputFactory inputFactory = new InputFactory();
        String names = Console.readLine();
        List<Car> carNames = inputFactory.getCars(names);

        ResultView.printRoundQuestion();
        String round = Console.readLine();
        int racingRound = inputFactory.getRacingRound(round);

        Race race = new Race(carNames, racingRound);
        race.start();

        ResultView resultView = new ResultView();
        resultView.printWinners(race.getCars());
    }
}
