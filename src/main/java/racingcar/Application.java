package racingcar;

import java.io.PrintStream;

public class Application {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        RacingGame game = new RacingGame();

        printStream.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        game.enterCarName();
    }
}
