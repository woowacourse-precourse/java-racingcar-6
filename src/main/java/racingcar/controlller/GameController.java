package racingcar.controlller;

abstract class GameController {
    protected boolean isRunning;

    public GameController(boolean running) {
        this.isRunning = running;
    }

    public abstract void run();

    public abstract void startGame();
}
