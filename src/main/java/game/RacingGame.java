package game;

public class RacingGame {
    public GameStatus status;

    public RacingGame() {
        status = GameStatus.READY;
    }

    public void run() {
        switch (status) {
            case READY -> this.ready();
            case PROCEEDING -> this.proceed();
            case END -> this.end();
            default -> throw new IllegalStateException("Unexpected value: " + this.status);
        }
    }

    private void ready() {

    }

    private void proceed() {

    }

    private void end() {

    }
}
