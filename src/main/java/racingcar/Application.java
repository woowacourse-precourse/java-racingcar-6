package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Machines machines = new Machines();
        RaceLap raceLap = new RaceLap();
        PaceComputer paceComputer = new PaceComputer();
        LeaderBoard leaderBoard = new LeaderBoard();

        machines.showMessage();
        machines.getInput();

        raceLap.showMessage();
        raceLap.getInput();

        leaderBoard.showRace(machines, raceLap, paceComputer);

        Console.close();
    }
}