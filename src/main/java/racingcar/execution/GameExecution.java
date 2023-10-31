package racingcar.execution;

public class GameExecution {
    private final GameInput gameInput;
    private final GameOutput gameOutput;

    public GameExecution() {
        this.gameInput = new ConsoleInput();
        this.gameOutput = new ConsoleOutput();
    }

    public String receiveGameInput() {
        return gameInput.receiveInput();
    }

    public void printOutputString(String output) {
        gameOutput.printString(output);
    }
}
