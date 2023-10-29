package racingcar;

import java.io.PrintStream;

public class OutputInterface {

    PrintStream outputStream;

    OutputInterface() {
        this.outputStream = System.out;
    }

    public void println(String str) {
        outputStream.println(str);
    }

    public void printStage(RacingCarGame game){
        this.println(game.toString()+"\n");
    }

}
