package racingcar;

import racingcar.component.Racing;

public class Application {
    public static void main(String[] args) {
        Racing racing = new Racing();
        racing.getInfo();
        racing.start();
        racing.printMoves();
        racing.printWinner();
    }
}
