package racingcar.domain.entity;

public abstract class Game {
    private Long id;
    private GameType gameName;

    public void init(Long id, GameType gameName) {
        this.id = id;
        this.gameName = gameName;
    }

    public Long getId() {
        return id;
    }

    public GameType getGameName() {
        return gameName;
    }
}
