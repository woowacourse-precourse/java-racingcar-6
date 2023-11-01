package racingcar;

import racingcar.domain.Refree;

public class Application {
    public static void main(String[] args) {
        Refree refree = new Refree();
        refree.playRace();
        refree.getWinners();
        refree.printWinners();
    }
}
