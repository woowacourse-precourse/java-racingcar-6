package racingcar;

public class RacingCar {
    private String name;
    private int score;
    public RacingCar(String name) {
        this.setName(name);
    }
    private void setName(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    void move(int randomNumber) {
        if (randomNumber >=4) {
            score++;
        }
    }
}
