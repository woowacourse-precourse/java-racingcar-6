package racingcar.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RacingPlayer player = (RacingPlayer) obj;
        return Objects.equals(name, player.getName());
    }
}
