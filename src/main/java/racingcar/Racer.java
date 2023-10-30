package racingcar;

public class Racer {
    static int moveCount;

    private String name;

    private StringBuilder score;

    public Racer(String name) {
        this.name = name;
        this.score = new StringBuilder();
    }

    public void move(int randomNumber){
        if(randomNumber >= 4){
            score.append('-');
        }
    }
}
