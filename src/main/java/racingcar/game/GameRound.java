package racingcar.game;

public class GameRound {

    int round;

    public GameRound(int round) {
        this.round = round;
    }

    public void decrease(){
        this.round--;
    }

    public boolean isRunning() {
        return this.round > 0;
    }
}
