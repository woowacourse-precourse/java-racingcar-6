package racingcar.domain;

public class RacingPlayer {
    private final int id;
    private final String name;
    private int score;

    public RacingPlayer(int id, String name){
        this.id = id;
        this.name = name;
        this.score = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score += 1;
    }
}
