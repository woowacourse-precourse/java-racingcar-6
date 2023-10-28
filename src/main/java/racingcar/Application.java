package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Machines machines = new Machines();
        Lap lap = new Lap();
        PaceComputer paceComputer = new PaceComputer();
        LeaderBoard leaderBoard = new LeaderBoard();

        machines.showMessage();
        machines.getInput();

        lap.showMessage();
        lap.getInput();

        leaderBoard.showRace(machines, lap, paceComputer);

        Console.close();
    }
}