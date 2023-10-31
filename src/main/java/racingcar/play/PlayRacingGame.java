package racingcar.play;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.Texts;
import racingcar.model.Winners;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class PlayRacingGame {

    private Cars cars;
    private int roundCount;
    private int maxCount;

    public PlayRacingGame() {
        roundCount = 0;
        maxCount = 0;
    }

    public void input() {
        System.out.println(Texts.STARTINPUT);
        String tmpName = Console.readLine();

        cars = new Cars(tmpName);

        System.out.println(Texts.TRYCOUNTINPUT);
        String tmpCount = Console.readLine();


        roundCount = Integer.parseInt(tmpCount);

    }

    public void play() {
        System.out.println(Texts.EXCUTERESULT);
        Round round = new Round();
        for (int i = 0; i < roundCount; i++) {
            round.playRound(cars);
            round.printRound(cars);
            System.out.println();
        }
        maxCount = cars.getMaxCount();
    }

    public void printGameResult() {
        Winners winners = new Winners(cars, maxCount);
        winners.printWinners();
    }
}
