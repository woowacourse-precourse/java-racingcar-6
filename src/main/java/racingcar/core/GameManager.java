package racingcar.core;

public class GameManager {
    private final Input input;

    public GameManager(final Input input) {
        this.input = input;
    }

    public void play(){
        String stringNames = input.readNames();
        int tryNum = input.readTryNum();
    }

}
