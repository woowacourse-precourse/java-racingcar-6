package racingcar.model.dto;

public class GameResult {
    private final String name;
    private final int position;

    public GameResult(String name, int position) {
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
