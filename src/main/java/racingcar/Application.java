package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Cars cars = new Cars();
        RaceLap raceLap = new RaceLap();
        PaceComputer paceComputer = new PaceComputer();
        LeaderBoard leaderBoard = new LeaderBoard();

        cars.showMessage();
        cars.getInput();

        raceLap.showMessage();
        raceLap.getInput();

        leaderBoard.showRace(cars, raceLap, paceComputer);

        Console.close();
    }
}