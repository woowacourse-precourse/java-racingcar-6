package racingcar.module.domain;

public class Car {
    private Long id;
    private final String name;
    private final Long gameId;
    private int move;

    private Car(Long gameId, String name) {
        this.gameId = gameId;
        this.name = name;
    }

    public static Car from(Long gameId, String name) {
        return new Car(gameId, name);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }
}