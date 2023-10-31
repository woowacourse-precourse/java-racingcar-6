package racingcar;

import java.io.PrintStream;
import java.util.List;

public class OutputInterface {

    PrintStream outputStream;
    RacingCarGameRenderer renderer = new SimpleRacingCarGameRenderer();

    OutputInterface() {
        this.outputStream = System.out;
    }

    public void println(String str) {
        outputStream.println(str);
    }

    public void printStage(RacingCarGame game) {
        outputStream.println(game.render(renderer) + "\n");
    }

    public void printWinners(List<String> winners) {
        outputStream.println("최종 우승자 : " + String.join(", ", winners));
    }

}
