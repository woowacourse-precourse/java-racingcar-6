package racingcar.model.car.dto;

public class GameResult {
    private final String name;
    private final int position;

    public GameResult(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
