package racingcar.model;

import java.util.Objects;

public class RacingPlayer implements Player{
    private final String name;
    private int score = 0;
    public RacingPlayer(String name) {
        this.name = name;
    }
    public RacingPlayer(String name, int score){
        this.name = name;
        this.score = score;
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
        Player player = (Player) obj;
        return name.equals(player.getName());
    }
}
