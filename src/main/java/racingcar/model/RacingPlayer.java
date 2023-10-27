package racingcar.model;

public class RacingPlayer implements Player{
    private final String name;
    private int score = 0;
    public RacingPlayer(String name) {
        this.name = name;
    }
    @Override
    public void addWins() {
        this.score++;
    }
    @Override
    public int getWins() {
        return this.score;
    }
    @Override
    public String getName() {
        return this.name;
    }
}
