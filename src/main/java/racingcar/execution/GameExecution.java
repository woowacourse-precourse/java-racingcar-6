package racingcar.execution;

public class GameExecution {
    private final GameInput gameInput;
    private final GameOutput gameOutput;

    public GameExecution() {
        this.gameInput = new ConsoleInput();
        this.gameOutput = new ConsoleOutput();
    }

    public String scan() {
        return gameInput.scan();
    }

    public void print(String output) {
        gameOutput.print(output);
    }
}
