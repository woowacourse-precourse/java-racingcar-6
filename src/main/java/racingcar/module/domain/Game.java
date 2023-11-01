package racingcar.module.domain;

public class Game {

    private Long id;
    private final int trial;
    private int playNum;

    private Game(int trial) {
        this.trial = trial;
    }

    public static Game from(int play) {
        return new Game(play);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}