package racingcar;

public class Application {
    public static void main(String[] args) {
        Race race = new Race();
        Race game = race.InputForStart();
        game.play();
    }
}
