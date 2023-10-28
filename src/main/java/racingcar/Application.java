package racingcar;

public class Application {
    public static void main(String[] args) {
        try {
            Race race = new Race();
            race.play();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
