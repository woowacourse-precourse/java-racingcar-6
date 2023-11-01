package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ResultView.printEnterNameGuide();
        InputFactory inputFactory = new InputFactory();
        List<Car> carNames = inputFactory.getCars(Console.readLine());

        ResultView.printRoundQuestion();
        int racingRound = inputFactory.getRacingRound(Console.readLine());

        Race race = new Race(carNames, racingRound);
        race.start();

        ResultView resultView = new ResultView();
        resultView.printWinners(race.getCars());
    }
}
